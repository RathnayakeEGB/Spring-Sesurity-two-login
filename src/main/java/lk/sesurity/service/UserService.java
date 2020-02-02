package lk.sesurity.service;

import lk.sesurity.entities.User1;
import lk.sesurity.repositories.User1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private User1Repository user1Repository;

    @Autowired
    private PasswordEncoder encoder;

    public  String saveUser(User1 u){
        u.setPassword(encoder.encode(u.getPassword()));
        user1Repository.save(u);
        return "USER 1 Created...";
    }

    public boolean isUseExist(String userName)throws  Exception{
        return  user1Repository.existsByUserName(userName);
    }
}
