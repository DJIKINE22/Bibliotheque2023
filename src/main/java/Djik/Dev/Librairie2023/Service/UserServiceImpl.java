package Djik.Dev.Librairie2023.Service;

import Djik.Dev.Librairie2023.Dto.UserDto;
import Djik.Dev.Librairie2023.Respository.UserRepository;
import Djik.Dev.Librairie2023.entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
   UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDto userDto) {
        User utilisateur = new User(userDto.getNom(),userDto.getPrenom(),userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),userDto.getRole());
        return userRepository.save(utilisateur);
    }
}
