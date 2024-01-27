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
@Table(name = "rooms_check_in")
public class rooms_check_in {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_rooms_check_in;
    @ManyToMany
    @JoinColumn(name="fk_id_room")
    @NotNull
    private rooms room;
    @ManyToMany
    @JoinColumn(name="id_check_in")
    @NotNull
    private check_in id_check_in;
}