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
		Medicine paracetamol = new Medicine("Paracetamol", 10,"PARA789","para_url");
		Medicine panadol = new Medicine("Panadol", 30,"PAN789","pan_url");
		Medicine mixagrip = new Medicine("Mixagrip", 30,"MIX_345","mix__url");
		this.medicineService.createMedicine(paracetamol);
		this.medicineService.createMedicine(panadol);
		this.medicineService.createMedicine(mixagrip);
		
		List<DroneEntity> drones = new LinkedList<DroneEntity>();
		drones.add(new DroneEntity("DJI-MINI-SE","Lightweight", 100, 20, "LOADING",
				Arrays.asList(new Medicine[] {
						paracetamol,
						panadol
				})));

		drones.add(new DroneEntity("Autel-200","Middleweight", 300, 20, "IDLE",
				Arrays.asList(new Medicine[] {
						paracetamol,
						mixagrip
				})));
		drones.add(new DroneEntity("DJI-MAVIC-3","Headvyweight", 500, 50, "IDLE",
				Arrays.asList(new Medicine[] {
						panadol,
						mixagrip
				})));
		drones.add(new DroneEntity("DJI-PHANTOM-4","Headvyweight", 400, 20, "LOADED",
				Arrays.asList(new Medicine[] {
						
				})));
		for(DroneEntity drone : drones) {
			droneService.createDrone(drone);
		}
		
	}
}
