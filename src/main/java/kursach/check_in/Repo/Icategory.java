package kursach.check_in.Repo;
import kursach.check_in.DTO.PersonOrdersDTO;
import kursach.check_in.Models.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Icategory extends JpaRepository<category, Long> {
    @Query(
            value = """
                SELECT category.name_category as name, count(*) as count
                FROM category
                JOIN people on category.id_category = people.fk_id_category
                JOIN check_in_people on people.id_people = check_in_people.people_id_people
                JOIN check_in on check_in_people.check_in_id_check_in = check_in.id_check_in
                WHERE current_date BETWEEN check_in.check_in_date AND check_in.check_out_date
                GROUP BY category.name_category
            """,
            nativeQuery = true)
    List<PersonOrdersDTO> findCountedCategoriesByPeopleId(Long people_id);
}
