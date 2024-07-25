package com.innova.backend.repository;

import com.innova.backend.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ITotalSpendingCalc extends JpaRepository<Transactions, Integer> {

    @Query("SELECT SUM(t.amount) FROM transactions t WHERE t.date BETWEEN :startDate AND :endDate")
    int sumTransactionAmountByTransactionDateBetween(LocalDate startDate, LocalDate endDate);
}
