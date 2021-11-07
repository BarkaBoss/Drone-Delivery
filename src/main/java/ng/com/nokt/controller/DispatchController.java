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

import ng.com.nokt.model.DroneEntity;
import ng.com.nokt.repository.MedicineRepository;
import ng.com.nokt.service.DroneService;

@RestController
public class DispatchController {
	
	@Autowired
	DroneService droneService;
	
	@Autowired
	MedicineRepository medicineRepository;
	
	/*@RequestMapping("/drone/{id}")
	public String drone(@PathVariable Long id, Model model) {
		
	}*/
	@RequestMapping("/drone")
	public String hello() {
		return "Hello";
	}
	@RequestMapping("/drones")
	@GetMapping("/drones")
	public ResponseEntity<List<DroneEntity>> getAllDrones(){
		return ResponseEntity.ok().body(droneService.getAllDrones());
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
}
