package com.ramos.apiUsers.service;

import com.ramos.apiUsers.model.User;
import com.ramos.apiUsers.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javierrampob
 */
@Service
public class UserService {
    @Autowired 
    private UserRepository userRepository;
    public List<User>listUsers(){
        return userRepository.findAll();
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }
    public void editUser(User user, Integer id){
       userRepository.existsById(id);
   }
    public void removeUser (Integer id){
        userRepository.deleteById(id);
    }
}
