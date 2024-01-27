package kursach.check_in.Models;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;


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
    @OneToMany
    @JoinColumn(name = "id_building")
    @NonNull
    private Collection<rooms> rooms;
}
