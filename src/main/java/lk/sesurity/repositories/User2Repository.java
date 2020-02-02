package lk.sesurity.repositories;

import lk.sesurity.entities.User2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User2Repository extends JpaRepository<User2,Integer> {

    User2 findByUserName(String userName);

    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);

}
