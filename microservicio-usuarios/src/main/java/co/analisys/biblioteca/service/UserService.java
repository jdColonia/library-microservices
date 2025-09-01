package co.analisys.biblioteca.service;

import co.analisys.biblioteca.model.Email;
import co.analisys.biblioteca.model.User;
import co.analisys.biblioteca.model.UserId;
import co.analisys.biblioteca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(UserId id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void changeUserEmail(UserId id, Email newEmail) {
        User user = getUser(id);
        user.changeEmail(newEmail);
        userRepository.save(user);
    }
}