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
}
