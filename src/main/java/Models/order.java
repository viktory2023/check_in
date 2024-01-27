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
@Table(name = "orders")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_order;
    @NotNull
    private int  room_number;
    @NotNull
    private int order_number;
    @OneToOne
    @JoinColumn(name = "fk_id_decree")
    @NotNull
    private decree id_decree;
}