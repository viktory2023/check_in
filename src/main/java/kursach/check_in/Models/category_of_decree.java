package kursach.check_in.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "category_of_decree")
public class category_of_decree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_category;
    @NotNull
    private String name_category;
}
