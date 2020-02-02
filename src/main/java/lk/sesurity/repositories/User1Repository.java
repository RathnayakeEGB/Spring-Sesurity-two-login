package lk.sesurity.repositories;

import lk.sesurity.entities.User1;
import lk.sesurity.entities.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User1Repository extends JpaRepository<User1,Integer> {

    User1 findByUserName(String userName);

    boolean existsByUserName(String userName);

}
