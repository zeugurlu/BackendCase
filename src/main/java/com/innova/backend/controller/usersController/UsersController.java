package com.innova.backend.controller.usersController;

import com.innova.backend.entity.Transactions;
import com.innova.backend.entity.Users;
import com.innova.backend.service.users.IUsersService;
import com.innova.backend.service.users.impl.UsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
    private final IUsersService iUsersService;

    @GetMapping("/get/{id}")
    public Users getById(@PathVariable Integer id){
        try {
            logger.info("inside UserController.getById() worked.");
            return this.iUsersService.getById(id);
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }
    @GetMapping
    public List<Users> getAll(){
        try {
            logger.info("inside UserController.getAll() worked.");
            return this.iUsersService.getAll();
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }

//    @GetMapping("/getTransactions/{id}")
//    public List<Transactions> getTransactionsByUserId(@PathVariable Integer id) {
//        try {
//            logger.info("inside UserController.getTransactionsByUserId() worked.");
//            return this.iUsersService.getTransactionsByUserId(id);
//        } catch (Exception e) {
//            logger.error("Error", e);
//            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
//        }
//    }

    @PostMapping
    public Users add(@RequestBody Users users) {
        try {
            logger.info("inside UserController.post() worked.");
            return this.iUsersService.post(users);
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }

//    @PostMapping("/addTransaction/{id}")
//    public List<Transactions> addTransaction(@PathVariable Integer id, @RequestBody Transactions transactions) {
//        try {
//            logger.info("inside UserController.addTransaction() worked.");
//            return this.iUsersService.addTransactionToUser(id,transactions);
//        } catch (Exception e) {
//            logger.error("Error", e );
//            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public Users delete(@PathVariable Integer id) {
        try {
            logger.info("inside UsersController.delete() for id: {}", id);
            return this.iUsersService.delete(id);
        } catch (IllegalArgumentException e) {
            logger.error("User not found for id: {}", id, e);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error deleting user with id: {}", id, e);
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Error deleting user", e);
        }
    }

    @PutMapping("/put/{id}")
    public Users put(@PathVariable Integer id, @RequestBody Users users) {
        try {
            logger.info("inside UserController.put() worked.");
            return this.iUsersService.put(id, users);
        } catch (Exception e) {
            logger.error("Error", e );
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }

}
