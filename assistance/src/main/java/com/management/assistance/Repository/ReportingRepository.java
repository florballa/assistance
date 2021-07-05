package com.management.assistance.Repository;

import com.management.assistance.Model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportingRepository extends JpaRepository<ReportModel, Long> {

    @Query("SELECT count(r) from ReportModel r WHERE report_response = 'REPAIR_COMPLETED'")
    Integer findReportCompleted();

    @Query("SELECT count(r) from ReportModel r WHERE report_response = 'REPAIR_REFUSED'")
    Integer findReportRefused();

    @Query("SELECT SUM(price) FROM ReportModel GROUP BY user_id")
    Float getTotalPrice();

}
