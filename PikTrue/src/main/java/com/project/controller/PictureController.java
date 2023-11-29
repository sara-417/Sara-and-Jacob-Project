package com.project.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mapper.PictureRepository;
import com.project.mapper.TagRepository;
import com.project.mapper.UserRepository;
import com.project.model.Picture;
import com.project.model.Tag;
import com.project.model.User;

@RestController
public class PictureController {

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    @PostMapping("/uploadPicture")
    public String uploadPicture(
            @RequestParam("username") String username,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tags") String tags) {

        Picture picture = new Picture();
        
        User user = userRepository.findByUsername(username);
        if(user == null) {
        	return "Error! User not found!";
        }
        
        picture.setUser(user);
        picture.setTitle(title);
        picture.setDescription(description);

        String[] tagNames = tags.split(",");
        
        List<Tag> pictureTags = new ArrayList<>();

      /*  
        for (String tagName : tagNames) {
            tagName = tagName.trim();
            if (!tagName.isEmpty()) {
                Tag tag = searchByTag(tagName);
                if (tag == null) {
                    tag = new Tag();
                    tag.setName(tagName);
                    tagRepository.save(tag);
                }
                pictureTags.add(tag);
                
            }
        }

        picture.setTags(pictureTags);

        pictureRepository.save(picture);

        return "Picture uploaded successfully!";
        */
        return "okay sure";
        }
        
        @GetMapping("/searchByTag")
        public List<Picture> searchByTag(@RequestParam("tagName") String tagName) {
            List<Picture> pictures = pictureRepository.searchByTag(tagName);
            return pictures;
            
        //HTML code for Sara to implement this method
        /*<form action="/searchByTag" method="get">
    	<label for="tagName">Enter Tag Name:</label>
    	<input type="text" id="tagName" name="tagName">
    	<button type="submit">Search</button>
		</form>*/
    }
}
