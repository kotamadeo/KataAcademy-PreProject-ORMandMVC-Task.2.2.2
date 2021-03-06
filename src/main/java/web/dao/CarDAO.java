package web.dao;

import web.model.Car;

import java.util.List;

public interface CarDAO {

    List<Car> show(int number);

    void update(Car car, long id);

    Car getCar(long id);

    void create(Car car);

    void delete(long id);
}
