package ng.com.nokt.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="drone_tbl")
public class DroneEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="model")
	private String model;
	private int maxWeight;
	private int batteryCapacity;
	private String state;
	
	private List<Medicine> medicine;
	
	public DroneEntity() {
		super();
	}

	public DroneEntity(String serialNumber, String model, int maxWeight, int batteryCapacity, String state,
			List<Medicine> medicine) {
		super();
		this.serialNumber = serialNumber;
		this.model = model;
		this.maxWeight = maxWeight;
		this.batteryCapacity = batteryCapacity;
		this.state = state;
		this.medicine = medicine;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Medicine> getMedicine() {
		return medicine;
	}

	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}
	
	
	public boolean checkWeight(Medicine medicine) {
		int totalWeight = 0;
		
		for(Medicine carriedMedicine: getMedicine()) {
			totalWeight += carriedMedicine.getWeight();
		}
		totalWeight += medicine.getWeight();
		
		if(totalWeight > getMaxWeight()) {
			return false;
		}else {
			return true;
		}
	}
}
