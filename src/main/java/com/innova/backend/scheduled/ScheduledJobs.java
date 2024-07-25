package com.innova.backend.scheduled;

import com.innova.backend.repository.ITotalSpendingCalc;
import com.innova.backend.repository.ITransactions;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@RequiredArgsConstructor
public class ScheduledJobs {

    private final ITotalSpendingCalc iTotalSpendingCalc;

    @Scheduled(fixedRate = 86400000)
    public void calculateTotalTransactionAmountLastMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDate previousDate = currentDate.minusDays(30);

        int totalTransactionAmount = iTotalSpendingCalc.sumTransactionAmountByTransactionDateBetween(previousDate,currentDate);
        System.out.println("1 aylık toplam harcama miktarı: " + totalTransactionAmount);
    }

    @Scheduled(fixedRate = 86400000)
    public void calculateTotalTransactionAmountLastWeek() {
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();

        int totalTransactionAmount = iTotalSpendingCalc.sumTransactionAmountByTransactionDateBetween(startDate, endDate);
        System.out.println("1 haftadaki toplam harcama: " + totalTransactionAmount);
    }

    @Scheduled(fixedRate = 86400000)
    public void calculateTotalTransactionAmountLastDay() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.minusDays(1);

        int totalTransactionAmount = iTotalSpendingCalc.sumTransactionAmountByTransactionDateBetween(startDate,endDate);
        System.out.println("Günlük toplam harcama: " + totalTransactionAmount);
    }

}
