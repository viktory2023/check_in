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
@Table(name = "check_in_people")
public class check_in_people {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_check_in_people;
    @ManyToMany
    @JoinColumn(name="fk_id_people")
    @NotNull
    private people id_people;
    @ManyToMany
    @JoinColumn(name="id_check_in")
    @NotNull
    private check_in id_check_in;
}
