package ng.com.nokt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ng.com.nokt.model.Medicine;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{
}
