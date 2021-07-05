package com.management.assistance.Repository;

import com.management.assistance.Model.CostumerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostumerRepository extends JpaRepository<CostumerModel, Long> {

    @Query("SELECT c FROM CostumerModel c WHERE c.email = ?1")
    Optional<CostumerModel> findCostumerByEmail(String email);

    Optional<CostumerModel> findById(Long id);

}
