package com.example.hibernateejercicio5.dao;

import com.example.hibernateejercicio5.model.Tag;

import java.util.List;

public interface TagDAO {

    List<Tag> findAllTag();
    Tag findTagId(Long id);
    List<Tag> filterByColor(String color);

}
