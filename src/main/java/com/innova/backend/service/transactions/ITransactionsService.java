package com.innova.backend.service.transactions;

import com.innova.backend.entity.Transactions;
import com.innova.backend.entity.Users;

import java.util.List;

public interface ITransactionsService {
    List<Transactions> getAll();
    Transactions getById(Integer id);
    Transactions post(Transactions transactions);
    Transactions delete(Integer id);
}
