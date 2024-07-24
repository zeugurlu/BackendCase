package com.innova.backend.service.transactions.impl;

import com.innova.backend.entity.Transactions;
import com.innova.backend.entity.Users;
import com.innova.backend.repository.ITransactions;
import com.innova.backend.repository.IUsers;
import com.innova.backend.service.transactions.ITransactionsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionsService implements ITransactionsService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionsService.class);
    private final ITransactions transactions;

    @Override
    public List<Transactions> getAll() {
        return this.transactions.findAll();
    }
}
