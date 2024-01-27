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
    private order id_order;
}
