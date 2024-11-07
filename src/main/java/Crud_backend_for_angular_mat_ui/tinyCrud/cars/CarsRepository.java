package Crud_backend_for_angular_mat_ui.tinyCrud.cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {
    void deleteById(Long id);
}
