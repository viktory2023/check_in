package kursach.check_in.Repo;
import kursach.check_in.Models.building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ibuilding extends JpaRepository<building, Long> {
}
