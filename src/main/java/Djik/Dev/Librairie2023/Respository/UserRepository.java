package Djik.Dev.Librairie2023.Respository;

import Djik.Dev.Librairie2023.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
