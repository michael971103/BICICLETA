package model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date StartDate; //fecha de inicio
    private Date endDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "BikeId")
    @JsonIgnoreProperties("reservations")
    private Bike bike;

    @OneToOne
    @JsonIgnoreProperties("reservation")
    private Score score;








}
