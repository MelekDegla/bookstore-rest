package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.bookstore.entities.FeedBack;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<FeedBack,Long> {

    @Query("select f from FeedBack f where f.name like CONCAT('%',:recherche,'%') or f.lastname like CONCAT('%',:recherche,'%') or f.email like CONCAT('%',:recherche,'%') or f.phone like CONCAT('%',:recherche,'%') or f.subject like CONCAT('%',:recherche,'%') or f.message like CONCAT('%',:recherche,'%')")
    public List<FeedBack> search(String recherche);
}
