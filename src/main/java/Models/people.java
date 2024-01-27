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
    private category id_category;
    @OneToOne
    @JoinColumn(name = "fk_id_citizenship")
    @NotNull
    private citizenship id_citizenship;
}