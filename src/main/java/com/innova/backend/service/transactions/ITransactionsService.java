package com.innova.backend.service.transactions;

import com.innova.backend.entity.Transactions;

import java.util.List;

public interface ITransactionsService {
    List<Transactions> getAll();
}
