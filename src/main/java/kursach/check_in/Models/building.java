package kursach.check_in.Models;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;


@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "building")
public class building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_building;
    @NonNull
    private String name_street;
    @NonNull
    private int house_number;
    @NonNull
    private int case_number;
    @OneToMany
    @JoinColumn(name = "id_building")
    private Collection<rooms> rooms;
}
