package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> show(int number);

    void update(Car car, long id);

    Car getCar(long id);

    void create(Car car);

    void delete(long id);
}
