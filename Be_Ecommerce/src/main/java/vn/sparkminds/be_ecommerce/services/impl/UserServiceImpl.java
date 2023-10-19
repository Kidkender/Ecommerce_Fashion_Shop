package vn.sparkminds.be_ecommerce.services.impl;

import org.springframework.stereotype.Service;
import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.UserException;
import vn.sparkminds.be_ecommerce.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User findUserById(Long userId) throws UserException {
        return null;
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        return null;
    }
}
