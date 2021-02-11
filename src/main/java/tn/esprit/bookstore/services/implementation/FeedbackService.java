package tn.esprit.bookstore.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.bookstore.DTOs.AddFeedbackDTO;
import tn.esprit.bookstore.DTOs.AnswerFeedbackDTO;
import tn.esprit.bookstore.entities.Book;
import tn.esprit.bookstore.entities.Comment;
import tn.esprit.bookstore.entities.FeedBack;
import tn.esprit.bookstore.entities.User;
import tn.esprit.bookstore.repository.FeedbackRepository;
import tn.esprit.bookstore.repository.UserRepository;
import tn.esprit.bookstore.services.IFeedbackService;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    FeedbackRepository fr ;
    @Autowired
    UserRepository ur ;
    @Override
    public FeedBack save(AddFeedbackDTO feedback) {
        Date date = new Date();

        FeedBack f =new FeedBack();
        f.setCreatedAt(date.toInstant());
        f.setName(feedback.getName());
        f.setLastname(feedback.getLastname());
        f.setEmail(feedback.getEmail());
        f.setPhone(feedback.getPhone());
        f.setSubject(feedback.getSubject());
        f.setMessage(feedback.getMessage());
        f.setAnswered(false);
        f.setAnswer("");

        f.setUser(null);
        FeedBack feedBack1 = fr.save(f);
        System.out.println(f.isAnswered());
        return  feedBack1;
    }

    @Override
    public FeedBack answer(AnswerFeedbackDTO feedback) {
        FeedBack f = fr.findById(feedback.getId_feedback()).get();
        f.setAnswered(true);
        f.setAnswer(feedback.getAnswer());

        String host="mail.javatpoint.com";
        final String user="friends.online.bookstore@gmail.com";//change accordingly
        final String password="friendsforever2020";//change accordingly

        String to=f.getEmail();//change accordingly

        //Get the session object
        Properties props = new Properties();


        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });

        //Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("[Replied] :"+f.getSubject());
            message.setText(f.getAnswer());

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (MessagingException e) {e.printStackTrace();}

        FeedBack f1=fr.save(f);
        f1.setUser(null);

            return f1;
    }

    @Override
    public FeedBack findById(Long id) {
        return fr.findById(id).get();
    }

    @Override
    public List<FeedBack> findAll() {
        List<FeedBack> list = fr.findAll();
        for(FeedBack f : list) {

            f.setUser(null);
        }
        return list;
    }

    @Override
    public void deleteById(Long id) {
        fr.deleteById(id);

    }

    @Override
    public List<FeedBack> search(String recherche) {
        List<FeedBack> list = fr.search(recherche);

        for(FeedBack f : list){

            f.setUser(null);
        }
        return list;
    }
}
