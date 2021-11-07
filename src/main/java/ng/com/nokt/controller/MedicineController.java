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
import ng.com.nokt.model.Medicine;
import ng.com.nokt.repository.MedicineRepository;
import ng.com.nokt.service.DroneService;
import ng.com.nokt.service.MedicineService;

@RestController
public class MedicineController {

	@Autowired
	MedicineService medicineService;
	
	/*@RequestMapping("/drone/{id}")
	public String drone(@PathVariable Long id, Model model) {
		
	}*/
	
	@RequestMapping("/medicine")
	@GetMapping("/medicines")
	public ResponseEntity<List<Medicine>> getAllMedicines(){
		return ResponseEntity.ok().body(medicineService.getAllMedicine());
	}
	
	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id){
		return ResponseEntity.ok().body(medicineService.getMedicineById(id));
	}
	
	@PostMapping("/medicine")
	public ResponseEntity<Medicine> createMedicine(@RequestBody Medicine medicine){
		return ResponseEntity.ok().body(medicineService.createMedicine(medicine));
	}
	
	@PutMapping("/medicine/{id}")
	public ResponseEntity<Medicine> updateDrone(@PathVariable long id, @RequestBody Medicine medicine){
		return ResponseEntity.ok().body(medicineService.updateMedicine(medicine));
	}
	
	@DeleteMapping("/medicine/{id}")
	public HttpStatus deleteDrone(@PathVariable long id){
		this.medicineService.deleteMedicine(id);
		return HttpStatus.OK;
	}
}
