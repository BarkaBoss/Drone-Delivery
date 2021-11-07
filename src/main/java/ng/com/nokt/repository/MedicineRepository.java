package ng.com.nokt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ng.com.nokt.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{

}
