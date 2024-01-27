package Repo;
import Models.building;
import Models.rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Irooms extends JpaRepository<rooms, Long> {
    Object findBybuilding();
    Iterable<rooms> findBybuilding(building building);

    rooms one(Long idRoom);

    void edit(Long idRoom, int roomNumber, int floor, int numberOfPlaces, String costOfLiving, building building);
}
