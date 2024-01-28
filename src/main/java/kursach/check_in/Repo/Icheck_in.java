package kursach.check_in.Repo;
import kursach.check_in.Models.check_in;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface Icheck_in extends JpaRepository<check_in, Long> {
}
