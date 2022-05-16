package ru.University.UDB.entity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "\"UDBpublic\"", catalog = "University-Data-Base")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "tin", nullable = false, precision = 0)
    private Integer tin;
    @Basic
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Basic
    @Column(name = "flm", nullable = false, length = 150)
    private String flm;
    @Basic
    @Column(name = "step_up_admission", nullable = true)
    private Boolean stepUpAdmission;
    @Basic
    @Column(name = "gruppa_id", nullable = true)
    private Integer gruppaId;
}
