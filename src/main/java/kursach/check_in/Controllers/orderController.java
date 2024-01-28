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
@RequestMapping("order")
public class orderController {
    private final Iorder iorder;
    private final Idecree idecree;
    public orderController (Iorder iorder, Idecree idecree){
        this.iorder = iorder;
        this.idecree = idecree;
    }

    @GetMapping
    public  String all(Model model){
        Iterable<order> orderIterable = iorder.findAll();
        model.addAttribute("orderIterable", orderIterable);
        return "orders/order";
    }
    @PostMapping("add")
    public String add(@RequestParam int room_number,
                      @RequestParam int order_number,
                      @RequestParam Long id_decree) {
        order order = new order(
                room_number,
                order_number,
                idecree.findById(id_decree).orElseThrow());
        iorder.save(order);
        return "redirect:/order";
    }
    @PostMapping("delete/{id_order}")
    public String delete(@PathVariable(value = "id_order") Long id_order) {
        order order = iorder.findById(id_order).orElseThrow();
        iorder.delete(order);
        return "redirect:/order";
    }
    @GetMapping("{id_order}")
    public String one(@PathVariable(value = "id_order") Long id_order, Model model){
        order order = iorder.findById(id_order).orElseThrow();
        model.addAttribute("order", order);
        return "orders/order-creation";
    }
    @PostMapping("{id_order}")
    public String update(@PathVariable(value = "id_order") Long id_order,
                         @RequestParam int room_number,
                         @RequestParam int order_number,
                         @RequestParam Long id_decree) {
        order order = iorder.findById(id_order).orElseThrow();
        order.setRoom_number(room_number);
        order.setOrder_number(order_number);
        order.setDecree(idecree.findById(id_decree).orElseThrow());
        iorder.save(order);
        return "redirect:/order";
    }
}
