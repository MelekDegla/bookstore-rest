package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.DTOs.AddCommentDTO;
import tn.esprit.bookstore.DTOs.UpdateCommentDTO;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.Comment;
import tn.esprit.bookstore.entities.PBook;
import tn.esprit.bookstore.entities.User;
import tn.esprit.bookstore.repository.BookRepository;
import tn.esprit.bookstore.repository.CommentRepository;
import tn.esprit.bookstore.repository.PbookRepository;
import tn.esprit.bookstore.repository.UserRepository;
import tn.esprit.bookstore.services.ICommentService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

import java.util.Date;
import java.util.List;
@Service
public class CommentService implements ICommentService {
    private static final String POST_URL = "https://neutrinoapi-bad-word-filter.p.rapidapi.com/bad-word-filter";
    @Autowired
    CommentRepository cr;
    @Autowired
    UserRepository ur;
    @Autowired
    BookRepository ub;
    @Autowired
    PbookRepository pb;
    @Override
    public Comment save(AddCommentDTO comment) throws Exception {
        Date date = new Date();

        Comment c = new Comment();
        c.setCreatedAt(date.toInstant());
        c.setUpdateAt(date.toInstant());
//        c.setId(99L);
        User u= new User();
        u.setId(comment.getId_user());
        c.setUser(u);
        c.setText(getCleanComment(comment.getText()));

        Book b= new Book();
        b.setId(comment.getId_book());
        c.setBook(b);


        Comment comment1 = cr.save(c);
        comment1.setBook(null);
        comment1.setUser(null);


        
        return comment1;
    }

    @Override
    public Comment update(UpdateCommentDTO comment) {
        Comment c= cr.findById(comment.getId_comment()).get();
        System.out.println(comment.getId_user());
        System.out.println(c.getUser().getId());
        if(c.getUser().getId()==comment.getId_user()){


            c.setText(comment.getText());
            Comment newcomment = cr.save(c);
            newcomment.setUser(null);
            newcomment.setBook(null);
            return newcomment;
        }
        else {
            return null;
        }

    }

    @Override
    public Comment findById(Long id) {
        return cr.findById(id).get();
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> lc = cr.findAll();
        for(Comment c : lc){
            c.setBook(null);
            c.setUser(null);
        }
        return cr.findAll();
    }

    @Override
    public void deleteById(Long id) {
        cr.deleteById(id);

    }

    @Override
    public List<Comment> findByBook(Long id) {
        List<Comment> list = cr.getbybook(id);
        for(Comment c : list){
            c.setBook(null);
            c.setUser(null);
        }
        return list;

    }

    public String getCleanComment(String commentBody) throws Exception {
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");


        con.setRequestProperty("x-rapidapi-key", "8ab149114dmsh80111528716ca1cp1857e9jsn2dd75a72da34");
        con.setRequestProperty("x-rapidapi-host", "neutrinoapi-bad-word-filter.p.rapidapi.com");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String POST_PARAMS = "censor-character=*&content="+commentBody;

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            JSONObject data = new JSONObject(response.toString());
            String censored_content = data.getString("censored-content");
            return censored_content;
        } else {
            System.out.println("POST request not worked");
            return "REQUEST_ERROR";
        }

    }
}
