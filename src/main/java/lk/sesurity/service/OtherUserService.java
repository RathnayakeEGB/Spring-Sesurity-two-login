package lk.sesurity.service;

import lk.sesurity.entities.User2;
import lk.sesurity.repositories.User2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OtherUserService {

    @Autowired
   private User2Repository user2Repository;


    @Autowired
   private PasswordEncoder encoder;

    public String createNewOtherUser(User2 u){
        u.setPassword(encoder.encode(u.getPassword()));
        user2Repository.save(u);
        return "Sucess............";
    }

    public boolean isUserExist(String userName) throws Exception{
       return user2Repository.existsByUserName(userName);
    }

}
