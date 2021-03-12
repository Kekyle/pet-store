package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Tag;

public interface TagService {
    Tag createTag(Tag tag);

    Tag getTagById(long id);
}
