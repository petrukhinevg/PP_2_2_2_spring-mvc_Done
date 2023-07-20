package web.service;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    private List<Car> carList;

    public CarServiceImpl() {
        carList = new ArrayList<>();
        carList.add(new Car("Марка1", "Модель1", "Цвет1"));
        carList.add(new Car("Марка2", "Модель2", "Цвет2"));
        carList.add(new Car("Марка3", "Модель3", "Цвет3"));
        carList.add(new Car("Марка4", "Модель4", "Цвет4"));
        carList.add(new Car("Марка5", "Модель5", "Цвет5"));
    }

    public List<Car> getCars(int count) {
        if (count >= 5 || count <= 0) {
            return carList;
        } else {
            return carList.subList(0, count);
        }
    }
}
