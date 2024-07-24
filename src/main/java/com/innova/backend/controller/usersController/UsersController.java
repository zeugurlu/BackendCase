package com.innova.backend.controller.usersController;

import com.innova.backend.entity.Users;
import com.innova.backend.service.users.IUsersService;
import com.innova.backend.service.users.impl.UsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
    private final IUsersService iUsersService;

    @GetMapping
    public List<Users> getAll(){
        try {
            logger.info("inside CustomerController.getAll() worked.");
            return this.iUsersService.getAll();
        } catch (Exception e) {
            logger.error("Error", e );
            String message = "An error occurred while trying to getAll User data.";
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.toString());
        }
    }
}
