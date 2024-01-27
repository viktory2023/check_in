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
@Table(name = "building")
public class building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_building;
    @NotNull
    private String name_street;
    @NotNull
    private int house_number;
    @NotNull
    private int case_number;
}
