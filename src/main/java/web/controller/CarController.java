package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImpl;

import java.util.List;

@Controller
public class CarController {
    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", required = false, defaultValue = "0") int count, Model model) {
        List<Car> carList = carServiceImpl.getCars(count);
        model.addAttribute("carList", carList);
        return "cars";
    }
}