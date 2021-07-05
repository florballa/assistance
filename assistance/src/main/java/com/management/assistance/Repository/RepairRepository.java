package com.management.assistance.Repository;

import com.management.assistance.Model.RepairModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<RepairModel, Long> {
}
