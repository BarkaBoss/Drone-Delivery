package ng.com.nokt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import ng.com.nokt.model.DroneEntity;
import ng.com.nokt.model.Medicine;
import ng.com.nokt.service.DroneService;
import ng.com.nokt.service.MedicineService;

//@ComponentScan(basePackages=("ng.com.nokt.controller"))
@ComponentScan(basePackages = {"ng.com.nokt.controller", "ng.com.nokt.model", "ng.com.nokt.exception", "ng.com.nokt.service", "ng.com.nokt.repository" })
@SpringBootApplication()
public class DroneDeliveryApplication implements CommandLineRunner{

	@Autowired
	DroneService droneService;
	
	@Autowired
	MedicineService medicineService;
	
	public static void main(String[] args) {
		SpringApplication.run(DroneDeliveryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Medicine paracetamol = new Medicine("Paracetamol", 80,"PARA789","url_here");
		Medicine panadol = new Medicine("Panadol", 30,"PAN789","pan_url_here");
		this.medicineService.createMedicine(paracetamol);
		this.medicineService.createMedicine(panadol);
		
		List<DroneEntity> drones = new LinkedList<DroneEntity>();
		drones.add(new DroneEntity("DJI2672","LightWeight", 100, 50, "LOADING",
				Arrays.asList(new Medicine[] {
						paracetamol,
						panadol
				})));
		for(DroneEntity drone : drones) {
			droneService.createDrone(drone);
		}
		
	}
}
