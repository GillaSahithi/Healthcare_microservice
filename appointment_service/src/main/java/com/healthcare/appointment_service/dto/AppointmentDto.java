package com.healthcare.appointment_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.healthcare.appointment_service.domain.Appointment;

public record AppointmentDto(
        String id,

        @JsonProperty("appointment_date")
        String appointmentDate,
        @JsonProperty("appointment_time")
        String appointmentTime,
        @JsonProperty("patient_id")
        String patientId,
        @JsonProperty("patient_name")
        String patientName,
        @JsonProperty("patient_number")
        String patientNumber,
        @JsonProperty("doctor_id")
        String doctorId,
        @JsonProperty("doctor_name")
        String doctorName,

        String status) {

    public static AppointmentDto fromAppointment(Appointment response) {
        return new AppointmentDto( response.getId(), response.getAppointmentDate(),
                response.getAppointmentTime(), String.valueOf(response.getPatientId()), response.getPatientName(),
                response.getPatientNumber(), response.getDoctorId(), response.getDoctorName(),
                response.getStatus());
    }

    public Appointment toAppointment() {
        return new Appointment( appointmentDate, appointmentTime, Long.parseLong(patientId),
                patientName, patientNumber, doctorId, doctorName, status);
    }
}
