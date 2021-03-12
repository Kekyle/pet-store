package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Tag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository {
    List<Tag> tagList = new ArrayList<>();

    @Override
    public Tag createTag(Tag tag) {
        tagList.add(tag);
        return tag;
    }

    @Override
    public Tag getTagById(long id) {
        for (Tag tag : tagList) {
            if (tag.getId() == id){
                return tag;
            }
        }
        return null;
    }

    @Override
    public boolean containsById(long id) {
        for (Tag tag : tagList) {
            if (tag.getId() == id){
                return true;
            }
        }
        return false;
    }
}
