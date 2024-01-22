package edu.miu.SpringBootWebWAA.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    TransactionId, Date, Time, Principle, Operation

    private String transactionId;
    private Date date;
    private String time;
    private String principle; // this will be a fake static user since we don't have one
    private String operation;
}
