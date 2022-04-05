package com.lt.vu.hospital.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "Patient.findAll", query = "select a from Patient as a")
})
@Table(name = "PATIENT")
public class Patient implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "HOSPITAL_ID")
    @EqualsAndHashCode.Exclude
    private Hospital hospital;

    @ManyToMany
    @JoinTable(
            name = "PATIENT_DOCTOR",
            joinColumns = @JoinColumn(name = "PATIENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "DOCTOR_ID")
    )
    @NotNull
    @EqualsAndHashCode.Exclude
    private Set<Doctor> doctors;
}
