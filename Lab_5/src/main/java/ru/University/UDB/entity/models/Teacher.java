package ru.University.UDB.entity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "teacher", schema = "\"UDBpublic\"", catalog = "University-Data-Base")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "flm", nullable = false, length = 150)
    private String flm;
    @Basic
    @Column(name = "education_license", nullable = false, precision = 0)
    private Integer educationLicense;
    @Basic
    @Column(name = "gettig_started", nullable = false)
    private LocalDate gettigStarted;
    @Basic
    @Column(name = "discipline_id", nullable = true)
    private Integer disciplineId;
}
