package ng.com.nokt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ng.com.nokt.model.DroneEntity;

public interface DroneRepository extends JpaRepository<DroneEntity, Long>{
	
	@Query("SELECT drone FROM DroneEntity drone WHERE drone.state = 'IDLE' or drone.batteryCapacity > 25")
	List<DroneEntity> getAllDronesByState();
}
