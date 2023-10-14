package Djik.Dev.Librairie2023.Controller;

import Djik.Dev.Librairie2023.Respository.LivreRepository;
import Djik.Dev.Librairie2023.Service.LivreService;
import Djik.Dev.Librairie2023.entites.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class LivreController {
    private LivreRepository livreRepository;
    @Autowired
    private LivreService LivreSer;

    public LivreController(LivreService livreSer) {

        this.LivreSer = livreSer;
    }

    @GetMapping(path = "/")
    public String home(){

        return "home";
    }

    @GetMapping(path = "livre_create")
    public String create(){

        return "ResgiterBook";
    }
    @GetMapping(path = "all_livre")
    public ModelAndView livres(Livre L){
        List<Livre>list=LivreSer.alllivres();
       // ModelAndView m= new ModelAndView();
        //m.setViewName("livres");
        return new ModelAndView("livres", "livre" ,list);
    }
    @GetMapping(path = "livre_dispo")
    public String livre_dispo(){
        return "livre_dispo";
    }
    @PostMapping(path = "/save")
    public String AjoutLivre(@ModelAttribute Livre l){
        LivreSer.create(l);
        return "redirect:/all_livre";
    }

    @GetMapping("/UpdateBookForm/{id}")
    public String UpdateBookForm(@PathVariable("id") Integer id, org.springframework.ui.Model model) {
        Livre livre = LivreSer.getLivreById(id);
        model.addAttribute("livre", livre);  // Ajoute le livre à l'attribut "livre" du modèle
        return "UpdateBookForm";  // Assurez-vous que le nom de la vue correspond à votre configuration
    }

    @GetMapping("/delete/{id}")
    public String deleteLivre(@PathVariable("id") Integer id) {
        LivreSer.deleteLivreById(id);
        return "redirect:/all_livre";
    }
    }
