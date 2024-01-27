package Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "decrees")
public class decree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_decree;
    @NotNull
    private String name_decree;
    @NotNull
    private LocalDate date_of_formation;
    @OneToOne
    @JoinColumn(name = "fk_id_category")
    @NotNull
    private category_of_decree id_category;
}
