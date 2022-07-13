package web.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Car {
    private long id;
    @NotNull(message = "Type shouldn't be empty!")
    private String type;
    @NotNull(message = "Vendor shouldn't be empty!")
    private String vendor;
    @NotNull(message = "Model shouldn't be empty!")
    private String model;
    @NotNull(message = "Engine shouldn't be empty!")
    private String engine;
    @NotNull(message = "Color shouldn't be empty!")
    private String color;
    @NotNull(message = "Year of production shouldn't be empty!")
    @Min(1930)
    @Max(2022)
    private int yearOfProduction;
    @NotNull(message = "Price shouldn't be empty!")
    private int price;

    public Car(long id, String type, String vendor, String model, String engine, String color, int yearOfProduction,
               int price) {
        this.id = id;
        this.type = type;
        this.vendor = vendor;
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
    }

    public Car() {}
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
