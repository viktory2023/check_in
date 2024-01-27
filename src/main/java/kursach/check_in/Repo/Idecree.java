package kursach.check_in.Repo;
import kursach.check_in.Models.decree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Idecree extends JpaRepository<decree, Long> {
}