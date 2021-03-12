package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Token;

public interface TokenRepository {
    void saveToken(Token token);
    void deleteToken(String userName);
    boolean containsTokenByUserName(String userName);
    boolean containsToken(String token);
}
