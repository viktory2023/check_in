package kursach.check_in.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.Collection;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "check_in")
public class check_in {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_check_in;
    @NotNull
    private LocalDate check_in_date;
    @NotNull
    private LocalDate check_out_date;
    @OneToOne
    @JoinColumn(name="id_order")
    @NotNull
    private order order;
    @ManyToMany
    @JoinTable(name = "check_in_people")
    private Collection<people> peoples;
    @ManyToMany
    @JoinTable(name = "rooms_check_in")
    private Collection<rooms> rooms;

}
