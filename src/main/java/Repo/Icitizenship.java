package Repo;
import Models.citizenship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Icitizenship extends JpaRepository<citizenship, Long> {
}
