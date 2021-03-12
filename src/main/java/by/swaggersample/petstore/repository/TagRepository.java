package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Tag;

public interface TagRepository {
    Tag createTag(Tag tag);
    Tag getTagById(long id);
    boolean containsById(long id);
}
