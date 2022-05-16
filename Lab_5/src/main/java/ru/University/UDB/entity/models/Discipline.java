package ru.University.UDB.entity.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "discipline", schema = "\"UDBpublic\"", catalog = "University-Data-Base")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Discipline {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "naming", nullable = false, length = 50)
    private String naming;
}
