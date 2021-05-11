package com.example.hibernateejercicio5.service;

import com.example.hibernateejercicio5.model.Tag;

import java.util.List;

public interface TagService {

    List<Tag> findAllTag();
    Tag findTagId(Long id);
    List<Tag> filterByColor(String color);

    Tag createTag(Tag tagdata);
    Tag updateTag(Tag tagdata2);

}
