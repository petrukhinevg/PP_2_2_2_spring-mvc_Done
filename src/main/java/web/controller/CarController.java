package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private List<Car> carList;

    public CarController() {
        carList = new ArrayList<>();
        carList.add(new Car("Марка1", "Модель1", "Цвет1"));
        carList.add(new Car("Марка2", "Модель2", "Цвет2"));
        carList.add(new Car("Марка3", "Модель3", "Цвет3"));
        carList.add(new Car("Марка4", "Модель4", "Цвет4"));
        carList.add(new Car("Марка5", "Модель5", "Цвет5"));
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false, defaultValue = "0") int count, Model model) {
        if (count >= 5 || count <= 0) {
            // Если count ≥ 5 или не указан, выводим весь список машин
            model.addAttribute("carList", carList);
        } else {
            // Иначе выводим указанное число машин
            model.addAttribute("carList", carList.subList(0, count));
        }
        return "cars";
    }
}