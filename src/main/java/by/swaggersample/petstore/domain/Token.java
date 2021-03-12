package by.swaggersample.petstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String token;

    public Token(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    //1. Category
    //2. Tag
    //3. Token
    //4. User
    //5. Store
    //6. Pet
}
