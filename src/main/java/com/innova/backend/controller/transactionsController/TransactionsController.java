package com.innova.backend.controller.transactionsController;

import com.innova.backend.controller.usersController.UsersController;
import com.innova.backend.entity.Transactions;
import com.innova.backend.entity.Users;
import com.innova.backend.repository.IUsers;
import com.innova.backend.service.transactions.ITransactionsService;
import com.innova.backend.service.users.IUsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/transactions")
public class TransactionsController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
    private final ITransactionsService iTransactionsService;


    @GetMapping("/get/{id}")
    public Transactions getById(@PathVariable Integer id){
        try {
            logger.info("inside TransactionsController.getId() worked.");
            return this.iTransactionsService.getById(id);
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }

    @GetMapping
    public List<Transactions> getAll(){
        try {
            logger.info("inside UserController.getAll() worked.");
            return this.iTransactionsService.getAll();
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }

    @PostMapping
    public Transactions add(@RequestBody Transactions transactions) {
        try {
            logger.info("inside UserController.post() worked.");
            return this.iTransactionsService.post(transactions);
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }
}
