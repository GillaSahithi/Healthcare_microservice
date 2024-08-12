package com.healthcare.patient_service.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients",
        uniqueConstraints = {@UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "phone")})
@EntityListeners(AuditingEntityListener.class)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "my_seq", initialValue = 100, allocationSize = 1)
    private int patientId;

    private String fullName;
    private String email;
    private String address;
    private String phone;
    private LocalDate dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PreExistingIllness> preExistingIllness;

}
