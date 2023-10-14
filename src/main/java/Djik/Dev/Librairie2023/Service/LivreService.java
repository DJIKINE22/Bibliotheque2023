package Djik.Dev.Librairie2023.Service;

import Djik.Dev.Librairie2023.Respository.LivreRepository;
import Djik.Dev.Librairie2023.entites.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    private LivreRepository LivreRepo;
    public LivreService(LivreRepository livreRepo) {

        this.LivreRepo = livreRepo;
    }


    public  void  create(Livre l){

        LivreRepo.save(l);
    }
    public List<Livre> alllivres() {
        return this.LivreRepo.findAll();
    }


    public Livre getLivreById(Integer id) {
        Optional< Livre > optional = LivreRepo.findById(id);
        Livre livre = null;
        if (optional.isPresent()) {
            livre = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return livre;
    }
    public void deleteLivreById(Integer id) {
        LivreRepo.deleteById(id);
    }

    }
