package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Tag;
import by.swaggersample.petstore.repository.TagRepository;
import by.swaggersample.petstore.repository.jpa.TagDataRepository;
import by.swaggersample.petstore.service.exception.TagNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDataRepository tagRepository;

    @Override
    public Tag createTag(Tag tag) {
        log.info("method createTag has started");
        log.debug("tag : " + tag.toString());
        return tagRepository.save(tag);
    }

    @Override
    public Tag getTagById(long id) {
        log.info("method getTagById has started");
        log.debug("id = " + id);
        if (tagRepository.existsById(id)) {
            return tagRepository.getOne(id);
        }
        throw new TagNotFoundException("Tag not found");
    }
}
