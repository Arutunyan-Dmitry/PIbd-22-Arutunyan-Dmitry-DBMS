package ru.University.UDB.entity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Objects;

@Entity
@Table(name = "academical_performance", schema = "\"UDBpublic\"", catalog = "University-Data-Base")
@IdClass(AcademicalPerformancePK.class)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AcademicalPerformance {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id", nullable = false)
    private Integer studentId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "discipline_id", nullable = false)
    private Integer disciplineId;
    @Basic
    @Column(name = "mark", nullable = true, precision = 0)
    private BigInteger mark;
}
