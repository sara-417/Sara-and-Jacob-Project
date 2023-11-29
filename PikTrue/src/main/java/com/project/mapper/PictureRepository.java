package com.project.mapper;

import com.project.model.*;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
    
	//Spring Data JPA generates SQL SELECT and Results 
	
	List<Picture> searchByTag(String tagName);
	
	List<Picture> findAll();
	
}