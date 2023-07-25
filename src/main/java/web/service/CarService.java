package web.service;

import java.util.List;
import web.models.Car;

public interface CarService {
    List<Car> getCars(int count);
}