package com.lt.vu.hospital.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "Hospital.findAll", query = "select a from Hospital as a")
})
@Table(name = "HOSPITAL")
public class Hospital implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name="TITLE")
    private String title;

    @NotNull
    @Column(name="ADDRESS")
    private String address;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "hospital")
    private Set<Patient> patients;

    public Hospital(Long id, String title, String address){
        this.id = id;
        this.title = title;
        this.address = address;
    }
}
