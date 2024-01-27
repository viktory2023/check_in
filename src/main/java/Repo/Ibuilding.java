package Repo;
import Models.building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ibuilding extends JpaRepository<building, Long> {
}
