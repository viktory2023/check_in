package Models;

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
@Table(name = "category")
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_category;
    @NotNull
    private String name_category;
}
