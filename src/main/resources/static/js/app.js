// =========================
// LOAD DOCTORS
// =========================

async function loadDoctors(
    url = "http://localhost:8080/doctors"
) {

    const response = await fetch(url);

    const doctors = await response.json();

    const doctorList =
        document.getElementById("doctorList");

    if (!doctorList) return;

    doctorList.innerHTML = "";

    doctors.forEach(doctor => {

        doctorList.innerHTML += `

        <div class="col-md-4 mb-4">

            <div class="card p-3 card-shadow">

                <h4>${doctor.name}</h4>

                <p>
                    <strong>Specialization:</strong>
                    ${doctor.specialization}
                </p>

                <p>
                    <strong>Experience:</strong>
                    ${doctor.experience} years
                </p>

                <p>
                    <strong>Fee:</strong>
                    ₹${doctor.fee}
                </p>

                <button
                    class="btn btn-primary mb-3"
                    onclick="loadSlots(${doctor.id})">

                    View Slots

                </button>

                <div id="slots-${doctor.id}"></div>

            </div>

        </div>
        `;
    });
}

// =========================
// LOAD SLOTS
// =========================

async function loadSlots(doctorId) {

    const response = await fetch(
        `http://localhost:8080/slots/${doctorId}`
    );

    const slots = await response.json();

    const slotDiv =
        document.getElementById(`slots-${doctorId}`);

    slotDiv.innerHTML = "";

    // No slots available
    if (slots.length === 0) {

        slotDiv.innerHTML = `

            <div class="alert alert-secondary">

                No available slots

            </div>
        `;

        return;
    }

    // Display slots
    slots.forEach(slot => {

        slotDiv.innerHTML += `

        <div class="slot-box mb-2">

            <p>
                <strong>
                    ${formatDateTime(slot.slotTime)}
                </strong>
            </p>

            <button
                class="btn btn-success btn-sm"
                onclick="bookSlot(${slot.id})">

                Book Slot

            </button>

        </div>
        `;
    });
}

// =========================
// BOOK SLOT
// =========================

async function bookSlot(slotId) {

    const userName =
        prompt("Enter your name");

    if (!userName) return;

    const response = await fetch(
        `http://localhost:8080/bookings?slotId=${slotId}&userName=${userName}`,
        {
            method: "POST"
        }
    );

    if (response.ok) {

        alert("Booking successful!");

        // Refresh page completely
        location.reload();

    } else {

        const error =
            await response.text();

        alert(error);
    }
}

// =========================
// LOAD BOOKINGS
// =========================

async function loadBookings() {

    const response =
        await fetch(
            "http://localhost:8080/bookings"
        );

    const bookings =
        await response.json();

    const bookingList =
        document.getElementById("bookingList");

    if (!bookingList) return;

    bookingList.innerHTML = "";

    // No bookings
    if (bookings.length === 0) {

        bookingList.innerHTML = `

            <div class="alert alert-secondary">

                No bookings available

            </div>
        `;

        return;
    }

    // Display bookings
    bookings.forEach(booking => {

        bookingList.innerHTML += `

        <div class="card booking-card p-3 mb-3">

            <h5>
                ${booking.userName}
            </h5>

            <p>
                <strong>Doctor:</strong>
                ${booking.doctor.name}
            </p>

            <p>
                <strong>Specialization:</strong>
                ${booking.doctor.specialization}
            </p>

            <p>
                <strong>Slot:</strong>
                ${formatDateTime(
                        booking.slotTime
                    )}
            </p>

        </div>
        `;
    });
}

// =========================
// FILTER DOCTORS
// =========================

async function filterDoctors() {

    const specialization =
        document.getElementById(
            "filterSpecialization"
        ).value;

    let url =
        "http://localhost:8080/doctors";

    if (specialization) {

        url +=
            `?specialization=${specialization}`;
    }

    loadDoctors(url);
}

// =========================
// FORMAT DATE TIME
// =========================

function formatDateTime(dateTime) {

    const date = new Date(dateTime);

    return date.toLocaleString(
        "en-IN",
        {
            dateStyle: "medium",
            timeStyle: "short"
        }
    );
}