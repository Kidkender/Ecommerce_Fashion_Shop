package vn.sparkminds.be_ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.sparkminds.be_ecommerce.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String email);

}
