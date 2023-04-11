package com.UST.Flightservices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="payment_info")
public class Paymentinfo {
    @Id
   @GeneratedValue
    @GenericGenerator(name="uuid2",strategy="org.hybernate.id.UUIDGenerator")

    private String PaymentId;
    private String accountNo;
    private String  CardType;
    private Double amount;
    private Long passengerId;

}
