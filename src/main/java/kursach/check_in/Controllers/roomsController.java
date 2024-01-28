package kursach.check_in.Controllers;

import kursach.check_in.Models.*;
import kursach.check_in.Repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("rooms")
public class roomsController {
    private final Irooms irooms;
    private final Ibuilding ibuilding;

    @GetMapping
    public  String all(Model model){
        Iterable<rooms> roomsIterable = irooms.findAll();
        model.addAttribute("roomsIterable", roomsIterable);
        return "rooms/rooms";
    }
    @PostMapping("add")
    public String add(@RequestParam int room_number,
                      @RequestParam int floor,
                      @RequestParam int number_of_places,
                      @RequestParam String cost_of_living,
                      @RequestParam Long id_building) {
        rooms rooms = new rooms(
                room_number,
                floor,
                number_of_places,
                cost_of_living,
                ibuilding.findById(id_building).orElseThrow());
        irooms.save(rooms);
        return "redirect:/rooms";
    }
    @PostMapping("delete/{id_room}")
    public String delete(@PathVariable(value = "id_room") Long id_room) {
        rooms rooms = irooms.findById(id_room).orElseThrow();
        irooms.delete(rooms);
        return "redirect:/rooms";
    }
    @GetMapping("{id_room}")
    public String one(@PathVariable(value = "id_room") Long id_room, Model model){
        rooms rooms = irooms.findById(id_room).orElseThrow();
        model.addAttribute("rooms", rooms);
        return "rooms/rooms-creation";
    }
    @PostMapping("{id_room}")
    public String update(@PathVariable(value = "id_room") Long id_room,
                         @RequestParam int room_number,
                         @RequestParam int floor,
                         @RequestParam int number_of_places,
                         @RequestParam String cost_of_living,
                         @RequestParam Long id_building) {
        rooms rooms = irooms.findById(id_room).orElseThrow();
        rooms.setRoom_number(room_number);
        rooms.setCost_of_living(cost_of_living);
        rooms.setFloor(floor);
        rooms.setBuilding(ibuilding.findById(id_building).orElseThrow());
        rooms.setNumber_of_places(number_of_places);
        irooms.save(rooms);
        return "redirect:/rooms";
    }
}
