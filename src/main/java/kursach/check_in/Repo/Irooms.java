package kursach.check_in.Repo;
import kursach.check_in.Models.building;
import kursach.check_in.Models.rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Irooms extends JpaRepository<rooms, Long> {
    Iterable<rooms> findBybuilding(building building);

}
