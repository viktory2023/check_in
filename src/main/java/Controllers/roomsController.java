package Controllers;

import Models.*;
import Repo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("rooms")
public class roomsController {
    private final Irooms irooms;
    private final Ibuilding ibuilding;

    public roomsController (Irooms irooms, Ibuilding ibuilding){
        this.irooms = irooms;
        this.ibuilding = ibuilding;
    }
    @GetMapping
    public  String all(Model model){
        Iterable<rooms> roomsIterable = irooms.findAll();
        Iterable<building> buildingIterable = ibuilding.findAll();
        model.addAttribute("roomsIterable", roomsIterable);
        model.addAttribute("buildingIterable", buildingIterable);
        return "rooms";
    }
    @PostMapping("add")
    public String add(@RequestParam int room_number,
                      @RequestParam int floor,
                      @RequestParam int number_of_places,
                      @RequestParam String cost_of_living,
                      @RequestParam building building) {
        rooms rooms = new rooms(room_number, floor, number_of_places, cost_of_living, building);
        irooms.save(rooms);
        return "redirect:/rooms";
    }
    @PostMapping("delete/{id_room}")
    public String delete(@PathVariable(value = "id_room") Long id_room) {
        rooms rooms = irooms.findById(id_room).orElseThrow();
        return "redirect:/rooms";
    }
    @GetMapping("{id_room}")
    public String one(@PathVariable(value = "id_room") Long id_room, Model model){
        rooms rooms = irooms.one(id_room);
        Iterable<Models.rooms> roomsIterable = irooms.findAll();
        Iterable<building> buildingIterable = ibuilding.findAll();
        model.addAttribute("rooms", roomsIterable);
        model.addAttribute("building", buildingIterable);
        return "rooms-creation";
    }
    @PostMapping("{id_room}")
    public String update(@PathVariable(value = "id_room") Long id_room,
                         @RequestParam int room_number,
                         @RequestParam int floor,
                         @RequestParam int number_of_places,
                         @RequestParam String cost_of_living,
                         @RequestParam building building) {
        rooms rooms = irooms.findById(id_room).orElseThrow();
        rooms.setRoom_number(room_number);
        rooms.setCost_of_living(cost_of_living);
        rooms.setFloor(floor);
        rooms.setId_building(building);
        rooms.setNumber_of_places(number_of_places);
        irooms.save(rooms);
        return "redirect:/rooms";
    }
}
