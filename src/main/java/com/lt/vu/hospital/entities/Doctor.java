package com.lt.vu.hospital.entities;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "Doctor.findAll", query = "select a from Doctor as a")
})
@Table(name = "DOCTOR")
public class Doctor implements Serializable {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name="NAME")
    private String name;


    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "doctors")
    private Set<Patient> patients;

}