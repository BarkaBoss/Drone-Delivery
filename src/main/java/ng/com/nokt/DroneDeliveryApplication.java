package ng.com.nokt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

import ng.com.nokt.model.Medicine;
import ng.com.nokt.repository.MedicineRepository;
import ng.com.nokt.service.DroneService;
import ng.com.nokt.service.MedicineService;

//@ComponentScan(basePackages=("ng.com.nokt.controller"))
@ComponentScan(basePackages = {"ng.com.nokt.controller", "ng.com.nokt.model", "ng.com.nokt.exception", "ng.com.nokt.service", "ng.com.nokt.repository" })
@SpringBootApplication()
public class DroneDeliveryApplication implements CommandLineRunner{

	@Autowired
	DroneService droneService;
	
	@Autowired
	MedicineRepository medicineRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DroneDeliveryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Medicine paracetamol = new Medicine("paracetamol", 10,"GHJ789","url_here");
		
		this.medicineRepository.save(paracetamol);
		
	}
}
