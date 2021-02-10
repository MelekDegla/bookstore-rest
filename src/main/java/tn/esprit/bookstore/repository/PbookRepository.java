package tn.esprit.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.PBook;
import tn.esprit.bookstore.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface PbookRepository extends JpaRepository<PBook, Long> {
     public PBook findBookByTitle(String title) ;
   /* @Query(value = "SELECT * FROM book b WHERE b.category_id = ?1", nativeQuery = true)
    List<PBook> findByCategory(Long id);*/
//    @Query("SELECT b FROM PBook b join b.orderDetails od join od.order o join o.user u where u.id=?1 ORDER BY od.quantity DESC")
    public List<PBook> findAllByOrderDetails_Order_User(User id);

}
