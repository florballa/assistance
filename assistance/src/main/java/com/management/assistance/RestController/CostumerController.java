package com.management.assistance.RestController;

import com.management.assistance.Model.CostumerModel;
import com.management.assistance.Service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @GetMapping("/findAll")
    public List<CostumerModel> getCostumers() {

        return costumerService.findAll();

    }

    @GetMapping(path = "get/{costumerId}")
    public Optional<CostumerModel> findById(@PathVariable("costumerId") Long costumerId) {
        return costumerService.findById(costumerId);
    }

    @PostMapping("/addNew")
    public CostumerModel addNewCostumer(@RequestBody CostumerModel costumer) {
        costumerService.addNewCostumer(costumer);
        return costumer;
    }

    @PutMapping(path = "{costumerId}")
    public void updateCostumer(@PathVariable("costumerId") Long costumerId,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) String address,
                              @RequestParam(required = false) String phone) {

        costumerService.updateCostumer(costumerId, firstName, lastName, email, address, phone);
    }


    @DeleteMapping(path = "delete/{costumerId}")
    public void deleteCostumer(@PathVariable("costumerId") Long costumerId) {
        costumerService.deleteCostumer(costumerId);
    }

}
