package Djik.Dev.Librairie2023.Service;

import Djik.Dev.Librairie2023.Dto.UserDto;
import Djik.Dev.Librairie2023.entites.User;

public interface UserService {
    User save(UserDto userDto);
}
