package com.fsoft.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.BigIntegerType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "bookingOffice")
@Data
public class BookingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="officedId", nullable = false, unique = true)
    private int id;

    @Column(name ="endContractDealine", nullable = false,unique = false)
    @Temporal(TemporalType.DATE)
    private Date endContractDealine;

    @Column(name ="officeName", length = 50, nullable = false,unique = false)
    private String officeName;

    @Column(name ="officePhone", length = 11, nullable = false,unique = false)
    private String officePhone;

    @Column(name ="officePlace", length = 50,nullable = false,unique = false)
    private String officePlace;

    @Column(name ="officePrice", length = 20,nullable = false,unique = false)
    private int officePrice;

    @Column(name ="startContractDealine", nullable = false,unique = false)
    @Temporal(TemporalType.DATE)
    private Date startContractDealine;

    @ManyToOne()
    @JoinColumn(name = "tripId")
    private Trip trip;

    public BookingOffice(Date endContractDealine, String officeName, String officePhone, String officePlace, int officePrice, Date startContractDealine) {
        this.endContractDealine = endContractDealine;
        this.officeName = officeName;
        this.officePhone = officePhone;
        this.officePlace = officePlace;
        this.officePrice = officePrice;
        this.startContractDealine = startContractDealine;
    }

    public BookingOffice() {
    }
}
