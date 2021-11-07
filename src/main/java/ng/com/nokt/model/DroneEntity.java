package ng.com.nokt.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Table(name="drone_tbl")
public class DroneEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="serial_number", length = 100)
	private String serialNumber;
	
	@Column(name="model")
	private String model;
	
	@Max(message="Weight can not be more than 500grams", value = 500)
	@Column(name="max_weight")
	private int maxWeight;
	
	@Column(name="battery_capacity")
	private int batteryCapacity;
	
	@Column(name="state")
	private String state;
	
	@ManyToMany
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
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		if(serialNumber.length() <= 100) {
			this.serialNumber = serialNumber;
		}else {
			System.out.print("Serial Number Should Not be longer than 100 characters");
		}
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

		if(!getMedicine().isEmpty()) {
			for(Medicine carriedMedicine: getMedicine()) {
				totalWeight += carriedMedicine.getWeight();
			}
			System.out.println("Weight on drone"+ totalWeight);
		}
		totalWeight += medicine.getWeight();
		System.out.println("New Weight"+ totalWeight);
		
		if(totalWeight > getMaxWeight()) {
			return false;
		}else {
			return true;
		}
	}
}
