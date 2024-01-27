package Models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@Table(name = "rooms")
public class rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_room;
    @NonNull
    private int room_number;
    @NonNull
    private int floor;
    @NonNull
    private int number_of_places;
    @NonNull
    private String cost_of_living;
    @OneToMany
    @JoinColumn(name="fk_id_building")
    @NonNull
    private building id_building;

    public rooms(int roomNumber, int floor, int numberOfPlaces, String costOfLiving, building idbuilding) {
    }


    public void setRoom_number(int roomNumber) {
        this.room_number = roomNumber;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public void setNumber_of_places(int numberOfPlaces) {
        this.number_of_places = numberOfPlaces;
    }

    public int getNumber_of_places() {
        return number_of_places;
    }

    public void setCost_of_living(String costOfLiving) {
        this.cost_of_living = costOfLiving;
    }

    public String getCost_of_living() {
        return cost_of_living;
    }

    public void setId_building(building idBuilding) {
        this.id_building = idBuilding;
    }

    public building getId_building() {
        return id_building;
    }
}