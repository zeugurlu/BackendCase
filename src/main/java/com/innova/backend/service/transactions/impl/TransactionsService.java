package com.innova.backend.service.transactions.impl;

import com.innova.backend.entity.Users;
import com.innova.backend.repository.ITransactions;
import com.innova.backend.repository.IUsers;
import com.innova.backend.service.transactions.ITransactionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService implements ITransactionsService {

    private ITransactions transactions;
    private static final Logger logger = LoggerFactory.getLogger(TransactionsService.class);


}
