package Repo;
import Models.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iorder extends JpaRepository<order, Long> {
}