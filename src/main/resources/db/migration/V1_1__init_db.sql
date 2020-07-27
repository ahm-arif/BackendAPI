DROP TABLE IF EXISTS doctor_doctor_category;
DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS appointment_type;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS doctor_category;
DROP TABLE IF EXISTS symptom;

CREATE TABLE doctor
(
    doctor_id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    title VARCHAR(255),
    gender VARCHAR(255),
    DOB VARCHAR(255),
    phone VARCHAR(255),
    address VARCHAR(255),
    appuser_id INTEGER
);

CREATE TABLE doctor_category
(
    doctor_category_id SERIAL PRIMARY KEY NOT NULL,
    doctor_category_code VARCHAR(255),
    doctor_category_name VARCHAR(255)
);

CREATE TABLE doctor_doctor_category
(
    doctor_doctor_category_id SERIAL PRIMARY KEY NOT NULL,
    doctor_id INTEGER,
    doctor_category_id INTEGER,
    CONSTRAINT fk_doctor_doctor_category_doctor
        FOREIGN KEY(doctor_id)
        REFERENCES doctor(doctor_id),
    CONSTRAINT fk_doctor_doctor_category_doctor_category
        FOREIGN KEY(doctor_category_id)
        REFERENCES doctor_category(doctor_category_id)
);

CREATE TABLE appointment_type
(
    appointment_type_id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(255),
    description VARCHAR,
    price BIGINT
);

CREATE TABLE symptom
(
    symptom_id SERIAL PRIMARY KEY NOT NULL,
    description VARCHAR,
    level VARCHAR(255)
);

CREATE TABLE appointment
(
    appointment_id SERIAL PRIMARY KEY NOT NULL,
    doctor_id INTEGER,
    patient_id INTEGER,
    appointment_type_id INTEGER,
    prescription_id INTEGER,
    symptom_id INTEGER,
    complaint_details VARCHAR,
    CONSTRAINT fk_appointment_doctor
        FOREIGN KEY(doctor_id)
        REFERENCES doctor(doctor_id),
    CONSTRAINT fk_appointment_appointment_type
        FOREIGN KEY(appointment_type_id)
        REFERENCES appointment_type(appointment_type_id),
    CONSTRAINT fk_appointment_symptom_id
        FOREIGN KEY(symptom_id)
        REFERENCES symptom(symptom_id)
);