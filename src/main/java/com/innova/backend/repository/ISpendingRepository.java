package com.innova.backend.repository;

import com.innova.backend.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISpendingRepository extends JpaRepository<Transactions, Integer> {

    @Query("SELECT SUM(t.amount) FROM transactions t WHERE t.id = ?1")
    int getTotalSpendingById(Integer id);
}
