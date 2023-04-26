package com.ramos.apiUsers.repository;

import com.ramos.apiUsers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author javierrampob
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    
}
