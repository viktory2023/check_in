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
@Table(name = "citizenships")
public class citizenship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_citizenship;
    @NotNull
    private String country;
    @NotNull
    private String type_of_citizenship;
    @NotNull
    private String registration_address;
}
