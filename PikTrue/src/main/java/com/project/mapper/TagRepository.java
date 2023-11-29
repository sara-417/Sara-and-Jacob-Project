package com.project.mapper;

import com.project.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface TagRepository extends JpaRepository<Tag, Integer> {
 
	/*
    @GetMapping("/searchByTag")
    public List<Tag> searchByTag(@RequestParam("tagName") String tagName) {
        List<Picture> pictures = pictureRepository.searchByTag(tagName);
        return pictures;
	
	findByName(tagName)
	*/
}