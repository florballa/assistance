package com.management.assistance.RestController;

import com.management.assistance.Model.RepairModel;
import com.management.assistance.Model.ReportModel;
import com.management.assistance.Model.ReportResponse;
import com.management.assistance.Service.ReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.management.assistance.Service.ReportingService.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reporting")
public class ReportController {

    @Autowired
    private ReportingService reportingService;

    @GetMapping
    public GetReporting countRepairCompleted(){

        return reportingService.countingAll();

    }

    @GetMapping("/findAll")
    public List<ReportModel> getReports() {

        return reportingService.findAll();

    }

    @GetMapping(path = "get/{reportId}")
    public Optional<ReportModel> findById(@PathVariable("reportId") Long reportId) {
        return reportingService.findById(reportId);
    }

    @PostMapping("/addNew")
    public ReportModel addNewReport(@RequestBody ReportModel report) {
        reportingService.addNewReport(report);
        return report;
    }

    @PutMapping(path = "{reportId}")
    public void updateReport(@PathVariable("reportId") Long reportId,
                             @RequestParam(required = false) String description,
                             @RequestParam(required = false) float price,
                             @RequestParam(required = false) ReportResponse reportResponse,
                             @RequestParam(required = false) RepairModel repairModel) {

        reportingService.updateReport(reportId, description, price, reportResponse, repairModel);
    }


    @DeleteMapping(path = "delete/{reportId}")
    public void deleteReport(@PathVariable("reportId") Long reportId) {
        reportingService.deleteReport(reportId);
    }

}
