package com.innova.backend.service.users.impl;

import com.innova.backend.entity.Users;
import com.innova.backend.repository.IUsers;
import com.innova.backend.service.users.IUsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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


}
