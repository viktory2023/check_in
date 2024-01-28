package kursach.check_in.Repo;
import kursach.check_in.DTO.MoneyDTO;
import kursach.check_in.DTO.PersonOrdersDTO;
import kursach.check_in.Models.citizenship;
import kursach.check_in.Models.people;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Ipeople extends JpaRepository<people, Long> {
    @Query(
            value = """
                SELECT people.*
                FROM check_in
                JOIN check_in_people ON check_in.id_check_in = check_in_people.check_in_id_check_in
                JOIN people ON check_in_people.people_id_people = people.id_people
                JOIN rooms_check_in ON check_in.id_check_in = rooms_check_in.check_in_id_check_in
                JOIN rooms ON rooms_check_in.rooms_id_room = rooms.id_room
                WHERE current_date BETWEEN check_in.check_in_date AND check_in.check_out_date
                  AND rooms.id_building= :building_id
            """,
            nativeQuery = true)
    List<people> findAllPeopleByBuildingID(@Param("building_id") Long building_id);
    @Query(
            value = """
                SELECT people.*
                FROM check_in
                JOIN check_in_people ON check_in.id_check_in = check_in_people.check_in_id_check_in
                JOIN people ON check_in_people.people_id_people = people.id_people
                JOIN rooms_check_in ON check_in.id_check_in = rooms_check_in.check_in_id_check_in
                WHERE current_date BETWEEN check_in.check_in_date AND check_in.check_out_date
                  AND rooms_check_in.rooms_id_room = :room_id
            """,
            nativeQuery = true)
    List<people> findAllPeopleByRoomID(@Param("room_id") Long room_id);

    List<people> findAllByCitizenship_countryNot(String country);
    @Query(
            value = """
                SELECT people.*
                FROM check_in
                JOIN check_in_people ON check_in.id_check_in = check_in_people.check_in_id_check_in
                JOIN people ON check_in_people.people_id_people = people.id_people
                WHERE check_in.check_in_date >= date_tranc('month', current_date) + '1 month'::interval
            """, nativeQuery = true)
    List<people> findAllToNextMonth();

    @Query(
            value = """
                SELECT people.*, sum(rooms.cost_of_living) as money
                FROM check_in
                JOIN check_in_people ON check_in.id_check_in = check_in_people.check_in_id_check_in
                JOIN people ON check_in_people.people_id_people = people.id_people
                JOIN rooms_check_in ON check_in.id_check_in = rooms_check_in.check_in_id_check_in
                JOIN rooms ON rooms_check_in.rooms_id_room = rooms.id_room
                WHERE current_date BETWEEN check_in.check_in_date AND check_in.check_out_date
                GROUP BY people
            """, nativeQuery = true)
    List<MoneyDTO> getAllMoneyForPeople(Long months);
}