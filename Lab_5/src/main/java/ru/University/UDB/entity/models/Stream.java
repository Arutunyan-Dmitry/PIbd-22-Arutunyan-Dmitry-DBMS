package ru.University.UDB.entity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "stream", schema = "\"UDBpublic\"", catalog = "University-Data-Base")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Stream {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "getting_number", nullable = false, length = 10)
    private String gettingNumber;
    @Basic
    @Column(name = "education_learning_form", nullable = false, length = 10)
    private String educationLearningForm;
    @Basic
    @Column(name = "education_time_form", nullable = false, length = 10)
    private String educationTimeForm;
    @Basic
    @Column(name = "education_value_form", nullable = false, length = 10)
    private String educationValueForm;
    @Basic
    @Column(name = "department_id", nullable = true)
    private Integer departmentId;
}
