package com.management.assistance.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "REPORTING")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReportModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private float price;
    @Enumerated(EnumType.STRING)
    private ReportResponse reportResponse;

    @OneToOne
    @JoinColumn(name = "repair_id")
    private RepairModel repair;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "costumer_id")
    private CostumerModel costumer;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    UserModel user;

}
