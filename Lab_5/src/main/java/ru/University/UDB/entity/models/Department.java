package ru.University.UDB.entity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "department", schema = "\"UDBpublic\"", catalog = "University-Data-Base")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "naming", nullable = false, length = 50)
    private String naming;
    @Basic
    @Column(name = "faculty_id", nullable = true)
    private Integer facultyId;
}
