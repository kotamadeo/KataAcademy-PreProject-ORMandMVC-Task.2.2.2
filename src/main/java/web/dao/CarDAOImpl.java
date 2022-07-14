package web.dao;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDAOImpl implements CarDAO {
    private static long CAR_ID;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CAR_ID, "sedan", "Honda", "Civic", "turbocharged 1,5", "green", 2022, 25_000));
        cars.add(new Car(++CAR_ID, "SUV", "Mitsubishi", "Outlander", "four-cylinder 2,5", "Black", 2022, 35_000));
        cars.add(new Car(++CAR_ID, "sedan", "Hyundai", "Solaris", "1,0", "Yellow", 2018, 6_000));
        cars.add(new Car(++CAR_ID, "SUV", "Porsche", "Cayenne-Turbo-S", "2,5 hybrid", "metallic", 2020, 50_000));
        cars.add(new Car(++CAR_ID, "sport-car", "Porsche", "911", "2,5 hybrid", "metallic", 2020, 50_000));
        cars.add(new Car(++CAR_ID, "SUV", "KIA", "Telluride", "2,5 hybrid", "white", 2019, 43_000));
    }

    @Override
    public List<Car> show(int number) {
        if (number == 0 || number >= 5) {
            return cars;
        } else {
            return cars.stream().limit(number).collect(Collectors.toList());
        }
    }

    @Override
    public void update(Car car, long id) {
        Car carToUpdate = getCar(id);
        carToUpdate.setType(car.getType());
        carToUpdate.setVendor(car.getVendor());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setEngine(car.getEngine());
        carToUpdate.setYearOfProduction(car.getYearOfProduction());
        carToUpdate.setPrice(car.getPrice());
    }

    @Override
    public Car getCar(long id) {
        return cars.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    @Override
    public void create(Car car) {
        car.setId(++CAR_ID);
        cars.add(car);
    }

    @Override
    public void delete(long id) {
        cars.removeIf(car -> car.getId() == id);
    }

}
