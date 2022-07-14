package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import javax.validation.Valid;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService car;

    @Autowired
    public CarController(CarService car) {
        this.car = car;
    }

    @GetMapping()
    public String show(@RequestParam(value = "count", defaultValue = "0") int count, Model model) {
        model.addAttribute("cars", car.show(count));
        return "cars/show";
    }

    @GetMapping("/create")
    public String newPerson(@ModelAttribute("car") Car car) {
        return "cars/create";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") @Valid Car newCar, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cars/create";
        }
        car.create(newCar);
        return "redirect:/cars";
    }

    @GetMapping("/{id}")
    public String getCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", car.getCar(id));
        return "cars/car";
    }

    @GetMapping("/{id}/update")
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", car.getCar(id));
        return "cars/update";
    }

    @PatchMapping("/{id}")
    public String patch(@ModelAttribute("car") @Valid Car updateCar, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "cars/update";
        }
        car.update(updateCar, id);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        car.delete(id);
        return "redirect:/cars";
    }
}
