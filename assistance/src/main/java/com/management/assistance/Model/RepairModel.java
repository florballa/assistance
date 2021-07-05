package com.management.assistance.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "repairs")
public class RepairModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial_device", nullable = false, length = 30)
    private String serial_device;

    @Column(name = "brand", nullable = false, length = 30)
    private String brand;

    @Column(name = "template", nullable = false, length = 30)
    private String template;

    @Column(name = "description", nullable = false, length = 30)
    private String description;

    @Column(name = "purchase_date")
    private Date purchase_date;

    @Column(name = "expire_date")
    private Date expire_date;

    @Column(name = "additional_notes", nullable = false, length = 30)
    private String additional_notes;

    @Column(name = "pec", nullable = false, length = 30)
    private String pec;

    @Column(name = "sdi_code", nullable = false, length = 30)
    private String sdi_code;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costumer_id")
    CostumerModel costumer;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    UserModel user;

    @OneToOne
    @JoinColumn(name = "report_id")
    private ReportModel report;

    public RepairModel() {
    }

    public RepairModel(Long id, String serial_device, String brand, String template, String description, Date purchase_date, Date expire_date, String additional_notes, String pec, String sdi_code, CostumerModel costumer, ReportModel report, UserModel user){
        this.id = id;
        this.serial_device = serial_device;
        this.brand = brand;
        this.template = template;
        this.description = description;
        this.purchase_date = purchase_date;
        this.expire_date = expire_date;
        this.additional_notes = additional_notes;
        this.pec = pec;
        this.sdi_code = sdi_code;
        this.costumer = costumer;
        this.report = report;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial_device() {
        return serial_device;
    }

    public void setSerial_device(String serial_device) {
        this.serial_device = serial_device;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getPurchase_date() {
        return LocalDateTime.now();
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public String getAdditional_notes() {
        return additional_notes;
    }

    public void setAdditional_notes(String additional_notes) {
        this.additional_notes = additional_notes;
    }

    public String getPec() {
        return pec;
    }

    public void setPec(String pec) {
        this.pec = pec;
    }

    public String getSdi_code() {
        return sdi_code;
    }

    public void setSdi_code(String sdi_code) {
        this.sdi_code = sdi_code;
    }

    public CostumerModel getCostumer() {
        return costumer;
    }

    public void setCostumer(CostumerModel costumer) {
        this.costumer = costumer;
    }

    public ReportModel getReport() { return report; }

    public void setReport(ReportModel report) {
        this.report = report;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RepairModel{" +
                "id=" + id +
                ", serial_device='" + serial_device + '\'' +
                ", brand='" + brand + '\'' +
                ", template='" + template + '\'' +
                ", description='" + description + '\'' +
                ", purchase_date=" + purchase_date +
                ", expire_date=" + expire_date +
                ", additional_notes='" + additional_notes + '\'' +
                ", pec='" + pec + '\'' +
                ", sdi_code='" + sdi_code + '\'' +
                ", costumer=" + costumer +
                ", report=" + report +
                ", user=" + user +
                '}';
    }
}
