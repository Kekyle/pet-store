package by.swaggersample.petstore.repository.jpa;

import by.swaggersample.petstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<User, Long> {
    void deleteByUserName(String userName);
    User getByUserName(String userName);
    boolean existsByUserName(String userName);
}
