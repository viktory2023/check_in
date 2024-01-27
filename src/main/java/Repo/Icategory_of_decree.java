package Repo;
import Models.category_of_decree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Icategory_of_decree extends JpaRepository<category_of_decree, Long> {
}