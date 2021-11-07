package ng.com.nokt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ng.com.nokt.exception.ResourceNotFoundException;
import ng.com.nokt.model.Medicine;
import ng.com.nokt.repository.MedicineRepository;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService{

	@Autowired
	MedicineRepository medicineRepository;

	@Override
	public Medicine createMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		Optional<Medicine> medicineDb = this.medicineRepository.findById(medicine.getId());
		
		if(medicineDb.isPresent()) {
			Medicine medicineUpdate = medicineDb.get();
			medicineUpdate.setName(medicine.getName());
			medicineUpdate.setWeight(medicine.getWeight());
			medicineUpdate.setCode(medicine.getCode());
			medicineUpdate.setImgUrl(medicine.getImgUrl());
			
			medicineRepository.save(medicineUpdate);
			return medicineUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found ID== "+medicine.getId());
		}
	}

	@Override
	public List<Medicine> getAllMedicine() {
		return this.medicineRepository.findAll();
	}

	@Override
	public Medicine getMedicineById(long id) {
		Optional<Medicine> medicineDb = this.medicineRepository.findById(id);
		if(medicineDb.isPresent()) {
			return medicineDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found ID== "+ id);
		}
	}

	@Override
	public void deleteMedicine(long id) {
		Optional<Medicine> medicineDb = this.medicineRepository.findById(id);
		if(medicineDb.isPresent()) {
			this.medicineRepository.delete(medicineDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found ID== "+ id);
		}
	}
}
