package by.swaggersample.petstore.repository.jpa;

import by.swaggersample.petstore.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDataRepository extends JpaRepository<Token, Long> {
    Token getByUserName(String username);
    void deleteByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByToken(String token);
}
