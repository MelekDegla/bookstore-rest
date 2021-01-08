package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.bookstore.entities.FeedBack;

public interface FeedbackRepository extends JpaRepository<FeedBack,Long> {
}
