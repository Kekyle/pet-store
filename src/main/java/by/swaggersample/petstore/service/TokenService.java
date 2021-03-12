package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Token;

public interface TokenService {
    void saveToken(Token token);
    void deleteToken(String userName);
    boolean containsTokenByUserName(String userName);
    boolean containsToken(String token);
}
