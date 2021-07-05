package com.management.assistance.Service;

import com.management.assistance.Model.CostumerModel;
import com.management.assistance.Model.RepairModel;
import com.management.assistance.Repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RepairService {

    @Autowired
    private RepairRepository repairRepository;

    public List<RepairModel> findAll(){
        return repairRepository.findAll();
    }

    public Optional<RepairModel> findById(Long repairId){
        return repairRepository.findById(repairId);
    }

    public void addNewRepair(RepairModel repair){
        repairRepository.save(repair);
    }

    @Transactional
    public void updateRepair(Long repairId, String serial_device, String brand, String template, String description, Date purchase_date, Date expire_date, String additional_notes, String pec, String sdi_code, CostumerModel costumer){

        RepairModel repairModel = repairRepository.findById(repairId)
                .orElseThrow(() -> new IllegalStateException(
                        "Costumer with ID " + repairId + " does not exists!"
                ));

        repairModel.setSerial_device(serial_device);
        repairModel.setBrand(brand);
        repairModel.setTemplate(template);
        repairModel.setDescription(description);
        repairModel.setPurchase_date(purchase_date);
        repairModel.setExpire_date(expire_date);
        repairModel.setAdditional_notes(additional_notes);
        repairModel.setPec(pec);
        repairModel.setSdi_code(sdi_code);

    }

    public void deleteRepair(Long repairId){
        boolean exists = repairRepository.existsById(repairId);
        if (!exists){
            throw new IllegalStateException(
                    "Repair with ID " + repairId + " does not exists!"
            );
        }
        repairRepository.deleteById(repairId);
    }
}
