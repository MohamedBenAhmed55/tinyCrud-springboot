package Crud_backend_for_angular_mat_ui.tinyCrud.cars;

import java.util.List;
import java.util.Optional;

public interface CarsService {
    Car saveCar(Car car);

    Car updateCar(int id, Car car);

    void deleteCar(int id);

    List<Car> getAllCars();

    Optional<Car> getCarById(long id);


}
