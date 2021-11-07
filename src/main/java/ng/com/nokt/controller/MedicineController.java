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

import ng.com.nokt.model.Medicine;
import ng.com.nokt.repository.MedicineRepository;
import ng.com.nokt.service.DroneService;

@RestController
public class MedicineController {

	@Autowired
	DroneService droneService;
	
	@Autowired
	MedicineRepository medicineRepository;
}
