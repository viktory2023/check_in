package kursach.check_in.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;


@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "rooms")
public class rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_room;
    @NonNull
    private int room_number;
    @NonNull
    private int floor;
    @NonNull
    private int number_of_places;
    @NonNull
    private String cost_of_living;
    @ManyToOne
    @JoinColumn(name = "id_building")
    @NonNull
    private building building;
    @ManyToMany
    @JoinTable(name = "rooms_check_in")
    private Collection<check_in> checkIns;
}