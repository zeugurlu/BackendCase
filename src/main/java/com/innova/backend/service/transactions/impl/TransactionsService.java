package com.innova.backend.service.transactions.impl;

import com.innova.backend.entity.Transactions;
import com.innova.backend.entity.Users;
import com.innova.backend.repository.ITransactions;
import com.innova.backend.repository.IUsers;
import com.innova.backend.service.transactions.ITransactionsService;
import com.innova.backend.service.users.IUsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionsService implements ITransactionsService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionsService.class);
    private final ITransactions transactions;
    private final IUsersService iUsersService;

    @Override
    public List<Transactions> getAll() {
        return this.transactions.findAll();
    }

    @Override
    public Transactions getById(Integer id) {
        logger.info("UsersService getById() function successfully worked.");
        Transactions idTransaction = this.transactions.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found."));
        return idTransaction;
    }

    @Override
    public Transactions post(Transactions transactions) {
        transactions.setDate(LocalDate.now());
        return this.transactions.save(transactions);
    }

    @Override
    public Transactions delete(Integer id) {
        logger.info("TransactionsService delete() function successfully worked.");
        Transactions deletedTransaction = this.transactions.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction with id " + id + " not found."));

        this.transactions.delete(deletedTransaction);
        return deletedTransaction;
    }


}
