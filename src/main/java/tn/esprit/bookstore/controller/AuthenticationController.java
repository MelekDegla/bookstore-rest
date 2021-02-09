package tn.esprit.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.bookstore.configurations.TokenProvider;
import tn.esprit.bookstore.entities.utils.LoginUser;
import tn.esprit.bookstore.entities.utils.OAuthToken;
import tn.esprit.bookstore.services.implementation.UserService;
@RestController
@RequestMapping( "api")
public class AuthenticationController {



    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "token", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser (@RequestBody LoginUser loginUser) throws AuthenticationException {

    final Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(),
                    loginUser.getPassword())
    );
        SecurityContextHolder.getContext().setAuthentication(authentication);
    final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new OAuthToken(token));
    }

}
