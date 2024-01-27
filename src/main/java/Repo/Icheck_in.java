package Repo;
import Models.check_in;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Icheck_in extends JpaRepository<check_in, Long> {
}
