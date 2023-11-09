package ng.com.nokt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ng.com.nokt.exception.ResourceNotFoundException;
import ng.com.nokt.model.DroneEntity;
import ng.com.nokt.model.Medicine;
import ng.com.nokt.service.DroneService;
import ng.com.nokt.service.MedicineService;

@RestController
public class DispatchController {
	
	@Autowired
	DroneService droneService;
	
	@Autowired
	MedicineService medicineService;
	
	@RequestMapping("/drone")
	public String hello() {
		return "Hello";
	}
	@RequestMapping("/drones")
	@GetMapping("/drones")
	public ResponseEntity<List<DroneEntity>> getAllDrones(){
		return ResponseEntity.ok().body(droneService.getAllDrones());
	}

	@GetMapping("/drone10/{capacity}")
	public ResponseEntity<List<DroneEntity>> getDroneCapacityGreaterThan(@PathVariable int capacity){
		return ResponseEntity.ok().body(droneService.getDroneByCapacityGreaterThan(capacity));
	}
	
	@GetMapping("/drones/{id}")
	public ResponseEntity<DroneEntity> getDroneById(@PathVariable long id){
		return ResponseEntity.ok().body(droneService.getDroneById(id));
	}
	
	@PostMapping("/drones")
	public ResponseEntity<DroneEntity> createDrone(@RequestBody DroneEntity drone){
		return ResponseEntity.ok().body(droneService.createDrone(drone));
	}
	
	@PutMapping("/drones/{id}")
	public ResponseEntity<DroneEntity> updateDrone(@PathVariable long id, @RequestBody DroneEntity drone){
		return ResponseEntity.ok().body(droneService.updateDrone(drone));
	}
	
	@DeleteMapping("/drones/{id}")
	public HttpStatus deleteDrone(@PathVariable long id){
		this.droneService.deleteDrone(id);
		return HttpStatus.OK;
	}
	
	@PostMapping("/drones/{id}/medicine/{medicineId}")
	public ResponseEntity<DroneEntity> addMedicineToDrone(@PathVariable Long id, @PathVariable Long medicineId){
		Medicine medicine = medicineService.getMedicineById(medicineId);
		DroneEntity drone = droneService.getDroneById(id);
		List<Medicine> medicineOnDrone = drone.getMedicine();
		
		int droneMaxWeight = drone.getMaxWeight();
		int totalCarryingWeight = 0;
		for(Medicine med : medicineOnDrone) {
			totalCarryingWeight += med.getWeight();
		}
		totalCarryingWeight += medicine.getWeight();
		
		if(totalCarryingWeight > droneMaxWeight || !drone.getState().equals("LOADING")) {
			ResponseEntity.ok().body("This Drone Can't Carry anymore weight");
			throw new ResourceNotFoundException("This Drone Can't Carry anymore weight");
		}else {
			drone.getMedicine().add(medicine);
			return ResponseEntity.ok().body(droneService.updateDrone(drone));
		}
	}
	
	@GetMapping("/drones/ready")
	public ResponseEntity<List<DroneEntity>> getDroneByState(){
		return ResponseEntity.ok().body(droneService.getAllDronesByState());
	}
	
	@GetMapping("/drones/battery/{id}")
	public ResponseEntity<Integer> getDroneBatteryById(@PathVariable long id){
		return ResponseEntity.ok().body(droneService.getDroneById(id).getBatteryCapacity());
	}
}
