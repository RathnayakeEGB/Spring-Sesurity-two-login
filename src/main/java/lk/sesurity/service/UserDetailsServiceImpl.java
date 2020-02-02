package lk.sesurity.service;

import lk.sesurity.entities.User1;
import lk.sesurity.entities.User2;
import lk.sesurity.repositories.User1Repository;
import lk.sesurity.repositories.User2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    User1Repository userRepository;

    @Autowired
    User2Repository user2Repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User1 user = userRepository.findByUserName(username);
           if(user==null){
               throw new UsernameNotFoundException("User Not Exception....");
           }
        return UserDetailsImpl.build(user ,new ArrayList<>());
    }

    @Transactional
    public UserDetails loadUserByUsernameANDType(String userName,String type){

        if(type.equals("A")){

            User1 user1 = userRepository.findByUserName(userName);
            return UserDetailsImpl.build(user1,new ArrayList<>());

        }else if(type.equals("O")){

            User2 user1 = user2Repository.findByUserName(userName);
            return UserDetailsImpl.build(user1,new ArrayList<>());

        }else {
          throw new  RuntimeException("[__ User Type Repository Error !");
        }

    }

}