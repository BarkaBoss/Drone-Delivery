package ng.com.nokt.service;

import java.util.List;


import ng.com.nokt.model.DroneEntity;

public interface DroneService {
	DroneEntity createDrone(DroneEntity drone);
	DroneEntity updateDrone(DroneEntity drone);
	List<DroneEntity> getAllDrones();
	List<DroneEntity> getAllDronesByState();
	DroneEntity getDroneById(long id);

	List <DroneEntity> getDroneByCapacityGreaterThan(int capacity);
	void deleteDrone(long id);
}
