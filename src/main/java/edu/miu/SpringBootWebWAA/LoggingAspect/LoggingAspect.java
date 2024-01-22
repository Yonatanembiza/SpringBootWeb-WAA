package edu.miu.SpringBootWebWAA.LoggingAspect;

import edu.miu.SpringBootWebWAA.entity.Logger;
import edu.miu.SpringBootWebWAA.repo.LoggerRepo;
import jakarta.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Aspect
@Component
public class LoggingAspect {
    @Autowired
    private LoggerRepo loggerRepo;

    @After("execution(* edu.miu.SpringBootWebWAA..*.*(..))")
    public void  loggerOperation(JoinPoint joinPoint){
        String transactionID = "txn "+System.currentTimeMillis();
        Date date = new Date();
        String time = "time "+System.currentTimeMillis();
        String principle = "User: Yonatan";
        String operation = joinPoint.getSignature().toString();

        // creating logger entity
        Logger loggerEntity = new Logger(transactionID, date, time, principle, operation);
        loggerRepo.save(loggerEntity);
    }
}
