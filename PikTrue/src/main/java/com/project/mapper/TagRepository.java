package com.project.mapper;

import com.project.model.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, Integer> {

	    List<Tag> findByName(String tagName);
    
	}