package Djik.Dev.Librairie2023.Controller;

import Djik.Dev.Librairie2023.Dto.UserDto;
import Djik.Dev.Librairie2023.Service.UserService;
import Djik.Dev.Librairie2023.Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String AfficherFormUserAjout(){
        return"FormUserAjout";
    }
    @PostMapping("/registration")
    public String AjoutUtilisateur(@ModelAttribute("users")UserDto userDto){
        userService.save(userDto);
        return "list";

    }
    @GetMapping("/login")
    public String Afficherlogin(){
        return"login";
    }

    @GetMapping("/admin-page")
    public String admindash(){
        return"admindashboard";
    }

    @GetMapping("user-page")
    public String simpleUserdash(){
        return"simpleUserDash";
    }


}
