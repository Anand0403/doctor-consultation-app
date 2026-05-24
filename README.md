# Doctor Consultation Web Application

## Live Demo
https://doctor-consultation-app-17ph.onrender.com

## GitHub Repository
https://github.com/Anand0403/doctor-consultation-app

---

## Overview

The Doctor Consultation Web Application is a full-stack web application developed using Spring Boot, Thymeleaf, PostgreSQL, and JavaScript.

The application allows:
- Admins to manage doctors and consultation slots
- Users to browse and filter doctors
- Users to book consultation appointments online

The system prevents double booking by automatically marking booked slots as unavailable.

---

## Features

### Admin Features
- Add Doctor
- Edit Doctor
- Delete Doctor
- View All Doctors
- Add Consultation Slots
- Manage Doctor Availability

### User Features
- Browse Available Doctors
- Filter Doctors by Specialization
- View Available Consultation Slots
- Book Appointments
- View Booked Appointments

### Booking Logic
- Prevents double booking
- Automatically hides booked slots after booking
- Stores booking details with doctor and slot information

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Hibernate

### Frontend
- Thymeleaf
- HTML
- CSS
- Bootstrap
- JavaScript

### Database
- PostgreSQL

### Deployment
- Render

---

## REST API Endpoints

### Doctors
- `POST /doctors`
- `GET /doctors`
- `PUT /doctors/{id}`
- `DELETE /doctors/{id}`

### Slots
- `POST /slots/{doctorId}`
- `GET /slots/{doctorId}`

### Bookings
- `POST /bookings`
- `GET /bookings`

---

## Running Locally

### Clone Repository

```bash
git clone https://github.com/Anand0403/doctor-consultation-app.git
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### Run Application

```bash
mvn spring-boot:run
```

Open in browser:

```text
http://localhost:8080
```

---

## Deployment

The application is deployed on Render with PostgreSQL cloud database integration using environment variables.

---

## Assumptions Made

- The application currently supports specialization-based filtering.
- Sample specializations such as Cardiology, Dermatology, and Neurology are used for demonstration purposes.
- Admin and User functionalities are separated through different UI pages without authentication.
- Slot booking is handled for a single user at a time using backend validation logic.
- The project focuses on functional completeness and core backend logic as per assignment requirements.

---

## Assignment Requirements Covered

- Doctor Management
- Slot Management
- Doctor Filtering
- Appointment Booking
- Double Booking Prevention
- REST API Implementation
- PostgreSQL Database Integration
- Frontend UI
- Cloud Deployment

---

## Future Improvements

- Authentication & Authorization
- Dynamic Specialization Management
- Search Functionality
- Pagination
- Email Notifications
- Calendar UI
- Docker Support
- Unit Testing

---

## Author

Anand Hiremani
