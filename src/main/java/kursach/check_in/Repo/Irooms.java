package kursach.check_in.Repo;
import kursach.check_in.Models.building;
import kursach.check_in.Models.rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Irooms extends JpaRepository<rooms, Long> {
    @Query(
            value = "SELECT r FROM rooms r WHERE r.id_building = ?1",
            nativeQuery = true)
    Iterable<rooms> findByBuildingId_building(Long building_id);

}
