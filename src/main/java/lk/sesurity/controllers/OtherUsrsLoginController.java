package lk.sesurity.controllers;

import lk.sesurity.config.JwtUtils;
import lk.sesurity.entities.User2;
import lk.sesurity.models.Login;
import lk.sesurity.models.ResponseJwt;
import lk.sesurity.service.OtherUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "other")
@CrossOrigin
public class OtherUsrsLoginController {

    @Autowired
    private OtherUserService otherUserService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping(value = "/createdUser")
    public String createNewUser(@RequestBody User2 user2){
       return otherUserService.createNewOtherUser(user2);
    }


    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody Login l){

        try {

            if(! otherUserService.isUserExist(l.getUserName())){
              return new ResponseEntity<>("USER NOT FOUNT", HttpStatus.UNAUTHORIZED);
            }
            String jwt = jwtUtils.generateJwtToken(l.getUserName());

            return new ResponseEntity<>(new ResponseJwt("O"+jwt,l.getUserName()),HttpStatus.OK);


        } catch (Exception e) {
            e.printStackTrace();
        }
    return null;
    }

}
