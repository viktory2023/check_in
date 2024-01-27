package kursach.check_in.Repo;
import kursach.check_in.Models.people;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ipeople extends JpaRepository<people, Long> {
}