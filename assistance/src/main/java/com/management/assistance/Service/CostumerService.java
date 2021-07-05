package com.management.assistance.Service;

import com.management.assistance.Model.CostumerModel;
import com.management.assistance.Repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    public List<CostumerModel> findAll(){
        return costumerRepository.findAll();
    }

    public Optional<CostumerModel> findById(Long costumerId){
        return costumerRepository.findById(costumerId);
    }

    public void addNewCostumer(CostumerModel costumer){

        Optional<CostumerModel> costumerOptional = costumerRepository.findCostumerByEmail(costumer.getEmail());
        if (costumerOptional.isPresent()){
            throw new IllegalStateException("Email taken!");
        }
        costumerRepository.save(costumer);
    }

    @Transactional
    public void updateCostumer(Long costumerId, String firstName,String lastName, String email, String address, String phone){

        CostumerModel costumer = costumerRepository.findById(costumerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Costumer with ID " + costumerId + " does not exists!"
                ));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(costumer.getFirstName(), firstName)){
            costumer.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(costumer.getLastName(), lastName)){
            costumer.setLastName(lastName);
        }

        if (address != null && address.length() > 0 && !Objects.equals(costumer.getAddress(), address)){
            costumer.setAddress(address);
        }

        if (phone != null && phone.length() > 0 && !Objects.equals(costumer.getPhone(), phone)){
            costumer.setPhone(phone);
        }

        if (email != null && email.length() > 0 && !Objects.equals(costumer.getEmail(), email)){
            Optional<CostumerModel> costumerOptional = costumerRepository.findCostumerByEmail(email);
            if (costumerOptional.isPresent()){
                throw new IllegalStateException("Email taken!");
            }
            costumer.setEmail(email);
        }

    }

    public void deleteCostumer(Long costumerId){
        boolean exists = costumerRepository.existsById(costumerId);
        if (!exists){
            throw new IllegalStateException(
                    "Costumer with ID " + costumerId + " does not exists!"
            );
        }
        costumerRepository.deleteById(costumerId);
    }

}
