package lk.sesurity.controllers;

import lk.sesurity.config.JwtUtils;
import lk.sesurity.entities.User1;
import lk.sesurity.models.Login;
import lk.sesurity.models.ResponseJwt;
import lk.sesurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/internalUsers")
@CrossOrigin
public class UserLoginController {

    @Autowired
    private  UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping(value = "/createUser")
    public String createNewUser(@RequestBody User1 u){

        u.setPassword(encoder.encode(u.getPassword()));
     return  userService.saveUser(u);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody Login l){

        try {

            if(! userService.isUseExist(l.getUserName())){
                return new ResponseEntity<>("USER NOT FOUNT", HttpStatus.UNAUTHORIZED);
            }
            String jwt = jwtUtils.generateJwtToken(l.getUserName());

            return new ResponseEntity<>(new ResponseJwt("A"+jwt,l.getUserName()),HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
