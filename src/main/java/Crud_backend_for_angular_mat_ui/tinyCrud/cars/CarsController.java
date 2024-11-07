package Crud_backend_for_angular_mat_ui.tinyCrud.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/cars")
public class CarsController {
    private final CarsService carsService;

    @Autowired
    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carsService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCarById(@PathVariable int id) {
        Optional<Car> car = carsService.getCarById(id);
        if (car.isEmpty()) {
            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok().body(car);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        Car createdCar = carsService.saveCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);

    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        carsService.deleteCar(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCar(@RequestBody Car car, @PathVariable int id) {
        Car updatedCar = carsService.updateCar(id, car);
        if (updatedCar != null) {
            return ResponseEntity.ok().body(updatedCar);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
