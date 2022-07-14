package web.service;

import org.springframework.stereotype.Component;
import web.dao.CarDAO;
import web.dao.CarDAOImpl;
import web.model.Car;

import java.util.List;

@Component

public class CarServiceImpl implements CarService {
    private final CarDAO carDAO = new CarDAOImpl();

    @Override
    public List<Car> show(int number) {
        return carDAO.show(number);
    }

    @Override
    public void update(Car car, long id) {
        carDAO.update(car, id);
    }

    @Override
    public Car getCar(long id) {
        return carDAO.getCar(id);
    }

    @Override
    public void create(Car car) {
        carDAO.create(car);
    }

    @Override
    public void delete(long id) {
        carDAO.delete(id);
    }
}
