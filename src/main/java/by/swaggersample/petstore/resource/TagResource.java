package by.swaggersample.petstore.resource;

import by.swaggersample.petstore.domain.Tag;
import by.swaggersample.petstore.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/tag")
@Slf4j
public class TagResource {

    @Autowired
    private TagService tagService;

    @PostMapping
    public Tag createTag(@Valid @RequestBody Tag tag){
        log.info("method createTag has started");
        log.debug("Tag :" + tag.toString());
        return tagService.createTag(tag);
    }

    @GetMapping(path = "/{tagId}")
    public Tag getTagById(@PathVariable long tagId){
        log.info("method getTagById has started");
        log.debug("tagId = " + tagId);
        return tagService.getTagById(tagId);
    }
}
