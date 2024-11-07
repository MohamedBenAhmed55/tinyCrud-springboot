package Crud_backend_for_angular_mat_ui.tinyCrud.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsServiceImpl implements CarsService {
    private final CarsRepository carsRepository;

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Car saveCar(Car car) {
        return carsRepository.save(car);
    }

    @Override
    public Car updateCar(int id, Car car) {
        Optional<Car> updatedCar = carsRepository.findById((long) id);
        if (updatedCar.isPresent()) {
            if (car.getYear() != null) {
                updatedCar.get().setYear(car.getYear());
            }

            if (car.getBrand() != null) {
                updatedCar.get().setBrand(car.getBrand());
            }
            if (car.getModel() != null) {
                updatedCar.get().setModel(car.getModel());
            }

            if (car.getColor() != null) {
                updatedCar.get().setColor(car.getColor());
            }

            return carsRepository.save(updatedCar.get());
        } else {
            return null;
        }

    }

    @Override
    public void deleteCar(int id) {
        carsRepository.deleteById((long) id);
    }

    @Override
    public List<Car> getAllCars() {
        return carsRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carsRepository.findById(id);

    }
}
