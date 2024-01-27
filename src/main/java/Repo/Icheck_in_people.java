package Repo;
import Models.check_in_people;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Icheck_in_people extends JpaRepository<check_in_people, Long> {
}
