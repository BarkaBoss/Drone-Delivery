package ng.com.nokt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ng.com.nokt.model.DroneEntity;

public interface DroneRepository extends JpaRepository<DroneEntity, Long>{

}
