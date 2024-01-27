package Repo;
import Models.rooms_check_in;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Irooms_check_in extends JpaRepository<rooms_check_in, Long> {
}
