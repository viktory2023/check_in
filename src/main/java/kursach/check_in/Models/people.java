package kursach.check_in.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "people")
public class people {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_people;
    @NotNull
    private String passport_data;
    @NotNull
    private String surname;
    @NotNull
    private String name;
    @NotNull
    private String patronymic;
    @NotNull
    private String gender;
    @NotNull
    private int age;
    @OneToOne
    @JoinColumn(name = "fk_id_category")
    @NotNull
    private category category;
    @OneToOne
    @JoinColumn(name = "fk_id_citizenship")
    @NotNull
    private citizenship citizenship;
    @ManyToMany
    @JoinTable(name = "check_in_people")
    private Collection<check_in> checkIns;
}