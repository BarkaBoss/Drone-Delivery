package ng.com.nokt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ng.com.nokt.exception.ResourceNotFoundException;
import ng.com.nokt.model.DroneEntity;
import ng.com.nokt.repository.DroneRepository;

@Service
@Transactional
public class DroneServiceImpl implements DroneService{

	@Autowired
	DroneRepository droneRepository;
	
	@Override
	public DroneEntity createDrone(DroneEntity drone) {
		return droneRepository.save(drone);
	}

	@Override
	public DroneEntity updateDrone(DroneEntity drone) {
		Optional<DroneEntity> droneDb = this.droneRepository.findById(drone.getId());
		
		if(droneDb.isPresent()) {
			DroneEntity droneUpdate = droneDb.get();
			droneUpdate.setId(drone.getId());
			droneUpdate.setSerialNumber(drone.getSerialNumber());
			droneUpdate.setModel(drone.getModel());
			droneUpdate.setBatteryCapacity(drone.getBatteryCapacity());
			droneUpdate.setMaxWeight(drone.getMaxWeight());
			droneUpdate.setState(drone.getState());
			droneUpdate.setMedicine(drone.getMedicine());
			
			droneRepository.save(droneUpdate);
			return droneUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found ID== "+drone.getId());
		}
	}

	@Override
	public DroneEntity getDroneById(long id) {
		Optional<DroneEntity> droneDb = this.droneRepository.findById(id);
		if(droneDb.isPresent()) {
			return droneDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found ID== "+ id);
		}
	}

	@Override
	public void deleteDrone(long id) {
		Optional<DroneEntity> droneDb = this.droneRepository.findById(id);
		if(droneDb.isPresent()) {
			this.droneRepository.delete(droneDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found ID== "+ id);
		}
	}

	@Override
	public List<DroneEntity> getAllDrones() {
		return this.droneRepository.findAll();
	}

}
