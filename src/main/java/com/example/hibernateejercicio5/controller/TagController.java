package com.example.hibernateejercicio5.controller;

import com.example.hibernateejercicio5.model.Tag;
import com.example.hibernateejercicio5.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {

    private final TagService tagService;


    public TagController(TagService tagService) {
        this.tagService = tagService;
    }
    /**
     * RETRIEVE - Find all tags
     * @return The call from TagService
     */
    @GetMapping("/tags")
    public List<Tag> findAllTag () {
        return tagService.findAllTag();
    }

    /**
     * RETRIEVE - Find tags by id
     * @param id Long Primary key - The number by which it will be filtered
     * @return The call from TagService
     */
    @GetMapping("/tag_id")
    public Tag findTagId (@RequestParam Long id) {
        return tagService.findTagId(id);
    }

    /**
     * RETRIEVE - Filter task by color
     * @param color String - The parameter by which it will be filtered
     * @return The call from TagService
     */
    @GetMapping("/tag_color")
    public List<Tag> filterByColor (@RequestParam String color) {
        return tagService.filterByColor(color);
    }

    /**
     * CREATE - Create tags in Postman
     * @param tagdata The name by which it will be filtered
     * @return The call from TagService
     */
    @PostMapping("/tags_create")
    public Tag createTag (@RequestBody Tag tagdata) {
        return tagService.createTag(tagdata);
    }

    /**
     * UPDATE - Update an tag in Postman
     * @param tagdata2 The name by which it will be filtered
     * @return The call from TagService
     */
    @PutMapping("/tags_update")
    public Tag updateTag (@RequestBody Tag tagdata2) {
        return tagService.updateTag(tagdata2);
    }
}
