package com.management.assistance.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "costumers")
public class CostumerModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "phone", nullable = false, length = 30)
    private String phone;

    @JsonManagedReference
    @OneToMany(mappedBy = "costumer", cascade = {CascadeType.ALL})
    private List<RepairModel> repair;

    @JsonManagedReference
    @OneToMany(mappedBy = "costumer", cascade = {CascadeType.ALL})
    private List<ReportModel> report;

    public CostumerModel() {
    }

    public CostumerModel(Long id, String firstName, String lastName, String email, String address, String phone, List<RepairModel> repair, List<ReportModel> report) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.repair = repair;
        this.report = report;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<RepairModel> getRepair() {
        return repair;
    }

    public void setRepair(List<RepairModel> repair) {
        this.repair = repair;
    }

    public List<ReportModel> getReport() {
        return report;
    }

    public void setReport(List<ReportModel> report) {
        this.report = report;
    }


    @Override
    public String toString() {
        return "CostumerModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", address=" + address + ", phone=" + phone + "]" + ", repair=" + repair + ", report=" + report +"]";
    }
}
