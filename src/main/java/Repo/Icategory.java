package Repo;
import Models.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Icategory extends JpaRepository<category, Long> {
}
