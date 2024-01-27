package kursach.check_in.Repo;
import kursach.check_in.Models.check_in;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Icheck_in extends JpaRepository<check_in, Long> {
}
