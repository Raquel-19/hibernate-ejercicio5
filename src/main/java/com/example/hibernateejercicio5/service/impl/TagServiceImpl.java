package com.example.hibernateejercicio5.service.impl;

import com.example.hibernateejercicio5.dao.TagDAO;
import com.example.hibernateejercicio5.model.Tag;
import com.example.hibernateejercicio5.repository.TagRepository;
import com.example.hibernateejercicio5.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private final TagDAO tagDAO;

    private final TagRepository repositoryTag;


    public TagServiceImpl(TagDAO tagDAO, TagRepository repositoryTag) {
        this.tagDAO = tagDAO;
        this.repositoryTag = repositoryTag;
    }

    @Override
    public List<Tag> findAllTag() {
        List<Tag> results = this.tagDAO.findAllTag();
        System.out.println("--------");
        return results;
    }

    @Override
    public Tag findTagId(Long id) {
        Tag results = this.tagDAO.findTagId(id);
        System.out.println("--------");
        return results;
    }
    @Override
    public List<Tag> filterByColor(String color) {
        List<Tag> results = this.tagDAO.filterByColor(color);
        System.out.println("--------");
        return results;
    }

    @Override
    public Tag createTag(Tag tagdata) {
        return repositoryTag.save(tagdata);
    }

    @Override
    public Tag updateTag(Tag tagdata2) {
        return repositoryTag.save(tagdata2);
    }
}
