package by.swaggersample.petstore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    private String urlImage;

    @OneToOne
    private Category category;

    @OneToMany
    private List<Tag> tags;

    @Enumerated(EnumType.STRING)
    private PetStatus petStatus;

    public Pet(@NotNull @NotEmpty @NotBlank String name, @NotNull @NotBlank @NotEmpty String urlImage, Category category, List<Tag> tags, PetStatus petStatus) {
        this.name = name;
        this.urlImage = urlImage;
        this.category = category;
        this.tags = tags;
        this.petStatus = petStatus;
    }
}
