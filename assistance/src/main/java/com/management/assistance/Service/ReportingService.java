package com.management.assistance.Service;

import com.management.assistance.Model.RepairModel;
import com.management.assistance.Model.ReportModel;
import com.management.assistance.Model.ReportResponse;
import com.management.assistance.Repository.ReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReportingService {

    @Autowired
    private ReportingRepository reportingRepository;

    public final class GetReporting {
         private final int countCompleted;
         private final int countRefused;
         private final float countPrice;

        public GetReporting(int countCompleted, int countRefused, float countPrice) {
            this.countCompleted = countCompleted;
            this.countRefused = countRefused;
            this.countPrice = countPrice;
        }

        public int getCountCompleted() {
            return countCompleted;
        }

        public int getCountRefused() {
            return countRefused;
        }

        public float getCountPrice() {
            return countPrice;
        }
    }

    public Integer countCompleted(){
        return reportingRepository.findReportCompleted();
    }

    public Integer countRefused(){
        return reportingRepository.findReportRefused();
    }

    public float countPrice(){
        return reportingRepository.getTotalPrice();
    }

    public GetReporting countingAll(){
        return new GetReporting(countCompleted(), countRefused(), countPrice());
    }

    public List<ReportModel> findAll() {
        return reportingRepository.findAll();
    }

    public Optional<ReportModel> findById(Long reportId) {
        return reportingRepository.findById(reportId);
    }

    public void addNewReport(ReportModel report) {
        reportingRepository.save(report);
    }

    @Transactional
    public void updateReport(Long reportId, String description, float price, ReportResponse response, RepairModel repairModel) {

        ReportModel reportModel = reportingRepository.findById(reportId)
                .orElseThrow(() -> new IllegalStateException(
                        "Costumer with ID " + reportId + " does not exists!"
                ));

        reportModel.setDescription(description);
        reportModel.setPrice(price);
        reportModel.setReportResponse(response);
        reportModel.setRepair(repairModel);

    }

    public void deleteReport(Long reportId) {
        boolean exists = reportingRepository.existsById(reportId);
        if (!exists) {
            throw new IllegalStateException(
                    "Report with ID " + reportId + " does not exists!"
            );
        }
        reportingRepository.deleteById(reportId);
    }
}
