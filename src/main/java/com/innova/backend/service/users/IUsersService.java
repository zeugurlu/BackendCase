package com.innova.backend.service.users;

import com.innova.backend.entity.Transactions;
import com.innova.backend.entity.Users;

import java.util.List;

public interface IUsersService {
    List<Users> getAll();
    Users getById(Integer id);
    Users post(Users users);
    Users delete(Integer id);
    Users put(Integer id,Users users);
//    List<Transactions> getTransactionsByUserId(Integer id);
//    Integer getTotalTransactionsAmount(Integer id);
//    List<Transactions> addTransactionToUser(Integer id, Transactions transactions);
}
