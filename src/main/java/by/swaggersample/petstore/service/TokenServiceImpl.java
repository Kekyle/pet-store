package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Token;
import by.swaggersample.petstore.repository.TokenRepository;
import by.swaggersample.petstore.repository.jpa.TokenDataRepository;
import by.swaggersample.petstore.resource.exception.AccessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDataRepository tokenRepository;

    @Override
    public void saveToken(Token token) {
        log.info("method saveToken has started");
        log.debug("token : " + token.toString());
        tokenRepository.save(token);
    }

    @Override
    public void deleteToken(String userName) {
        log.info("method deleteToken has started");
        log.debug("username = " + userName);
        tokenRepository.deleteByUserName(userName);
    }

    @Override
    public boolean containsTokenByUserName(String userName) {
        log.info("method containsTokenByUserName has started");
        log.debug("username = " + userName);
        return tokenRepository.existsByUserName(userName);
    }

    @Override
    public boolean containsToken(String token) {
        log.info("method containsToken has started");
        log.debug("token = " + token);
        if (token == null) throw new AccessException("Token not found! Please, sign in!");
        return tokenRepository.existsByToken(token);
    }
}
