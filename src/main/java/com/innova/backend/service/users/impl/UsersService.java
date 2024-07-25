package com.innova.backend.service.users.impl;

import com.innova.backend.entity.Transactions;
import com.innova.backend.entity.Users;
import com.innova.backend.repository.IUsers;
import com.innova.backend.service.users.IUsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService implements IUsersService {

    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);
    private final IUsers users;

    @Override
    public List<Users> getAll() {
        logger.info("UsersService getAll() function successfully worked.");
        return this.users.findAll();
    }

    @Override
    public Users getById(Integer id) {
        logger.info("UsersService getById() function successfully worked.");
        Users idUser = this.users.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found."));
        return idUser;
    }

    @Override
    public Users post(Users users) {
        logger.info("UsersService post() function successfully worked.");
        return this.users.save(users);
    }

    @Override
    public Users delete(Integer id) {
        logger.info("UsersService delete() function successfully worked.");
        Users deletedUser = this.users.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found."));

        this.users.delete(deletedUser);
        return deletedUser;
    }

    @Override
    public Users put(Integer id, Users users) {
        Users existingUser = this.users.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found."));

        existingUser.setUsername(users.getUsername());
        existingUser.setPassword(users.getPassword());

        return this.users.save(existingUser);
    }

//    @Override
//    public List<Transactions> getTransactionsByUserId(Integer id) {
//        Users existingUser = this.users.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found."));
//        return existingUser.getTransactions();
//    }

//    @Override
//    public Integer getTotalTransactionsAmount(Integer userId) {
//        Users user = this.users.findById(userId).orElse(null);
//        int totalAmount = 0;
//        if (user == null) {
//            logger.info("User not found");
//            return 0;
//        }else {
//            for (Transactions transaction : user.getTransactions()) {
//                totalAmount += transaction.getAmount();
//            }
//        }
//
//        return totalAmount;
//    }

//    public List<Transactions> addTransactionToUser(Integer id, Transactions transaction) {
//        Users user = this.users.findById(id).orElse(null);
//        if (user == null) {
//            logger.info("The user not found");
//            return null;
//        }

//          transaction.setDate(LocalDate.now());
//        Transactions transaction = new Transactions();
//        transaction.setAmount(amount);
//        transaction.setDescription(description);
//        transaction.setType(type);
//        transaction.setDate(date);
//        transaction.setUser(user);
//        user.getTransactions().add(transaction);
//
//        this.users.save(user);
//
//        return user.getTransactions();
//    }




}
