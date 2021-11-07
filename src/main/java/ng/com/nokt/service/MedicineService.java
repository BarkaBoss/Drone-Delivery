package ng.com.nokt.service;

import java.util.List;

import ng.com.nokt.model.Medicine;

public interface MedicineService {
	Medicine createMedicine(Medicine medicine);
	Medicine updateMedicine(Medicine medicine);
	List<Medicine> getAllMedicine();
	Medicine getMedicineId(long id);
	void deleteMedicine(long id);
}
