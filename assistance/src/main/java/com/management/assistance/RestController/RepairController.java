package com.management.assistance.RestController;

import com.management.assistance.Model.CostumerModel;
import com.management.assistance.Model.RepairModel;
import com.management.assistance.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @GetMapping("/findAll")
    public List<RepairModel> getRepairs() {

        return repairService.findAll();

    }

    @GetMapping(path = "get/{repairId}")
    public Optional<RepairModel> findById(@PathVariable("repairId") Long repairId) {
        return repairService.findById(repairId);
    }

    @PostMapping("/addNew")
    public RepairModel addNewRepair(@RequestBody RepairModel repair) {
        repairService.addNewRepair(repair);
        return repair;
    }

    @PutMapping(path = "{repairId}")
    public void updateRepair(@PathVariable("repairId") Long repairId,
                             @RequestParam(required = false) String serial_device,
                             @RequestParam(required = false) String brand,
                             @RequestParam(required = false) String template,
                             @RequestParam(required = false) String description,
                             @RequestParam(required = false) Date purchase_date,
                             @RequestParam(required = false) Date expire_date,
                             @RequestParam(required = false) String additional_notes,
                             @RequestParam(required = false) String pec,
                             @RequestParam(required = false) String sdi_code,
                             @RequestParam(required = false) CostumerModel costumer) {

        repairService.updateRepair(repairId, serial_device, brand, template, description, purchase_date, expire_date, additional_notes, pec, sdi_code, costumer);
    }


    @DeleteMapping(path = "delete/{repairId}")
    public void deleteRepair(@PathVariable("repairId") Long repairId) {
        repairService.deleteRepair(repairId);
    }

}
