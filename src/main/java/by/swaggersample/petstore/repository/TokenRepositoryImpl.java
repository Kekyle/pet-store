package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Token;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TokenRepositoryImpl implements TokenRepository {
    List<Token> tokens = new ArrayList<>();

    @Override
    public void saveToken(Token token) {
        tokens.add(token);
    }

    @Override
    public void deleteToken(String userName) {
        for (Token token : tokens) {
            if (token.getUserName().equals(userName)){
                tokens.remove(token);
                break;
            }
        }
    }

    @Override
    public boolean containsTokenByUserName(String userName) {
        for (Token token : tokens) {
            if (token.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsToken(String token) {
        for (Token token1 : tokens) {
            if (token1.getToken().equals(token)){
                return true;
            }
        }
        return false;
    }
}
