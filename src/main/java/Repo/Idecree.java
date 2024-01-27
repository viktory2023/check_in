package Repo;
import Models.decree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Idecree extends JpaRepository<decree, Long> {
}