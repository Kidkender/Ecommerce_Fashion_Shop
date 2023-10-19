package vn.sparkminds.be_ecommerce.services;

import vn.sparkminds.be_ecommerce.entities.User;
import vn.sparkminds.be_ecommerce.exceptions.UserException;

public interface UserService {
    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;


}
