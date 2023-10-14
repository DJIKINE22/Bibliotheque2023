package Djik.Dev.Librairie2023.Respository;

import Djik.Dev.Librairie2023.entites.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<Livre,Integer> {
}
