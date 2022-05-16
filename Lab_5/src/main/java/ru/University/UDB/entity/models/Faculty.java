package ru.University.UDB.entity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "faculty", schema = "\"UDBpublic\"", catalog = "University-Data-Base")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "abbriviation", nullable = false, length = 5)
    private String abbriviation;
    @Basic
    @Column(name = "studying_duration", nullable = false, length = 30)
    private String studyingDuration;
}
