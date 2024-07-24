package com.innova.backend.repository;

import com.innova.backend.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactions extends JpaRepository<Transactions,Integer> {
}
