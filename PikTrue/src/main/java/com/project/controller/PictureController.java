package com.project.controller;

import java.io.File;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;
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
            @RequestParam("tags") String tags//,
    		//@RequestParam("picture") MultipartFile pictureFile
            ) {

    	System.out.println("Step 1");
    	
        Picture picture = new Picture();
        
        User user = userRepository.findByUsername(username);
        if(user == null) {
        	return "Error! User not found!";
        }
        
        picture.setUser(user);
        picture.setTitle(title);
        picture.setDescription(description);
      /*  if (!pictureFile.isEmpty()) {
            try {
            	String fileName = pictureFile.getOriginalFilename();
                String filePath = "uploads/" + fileName;
                File file = new File(filePath);
                pictureFile.transferTo(file);
            } catch (Exception e) {
                e.printStackTrace();
                return "Error! Picture failed to upload!";
            }
        }*/
        
        List<Tag> tagList = new ArrayList<>();
        String[] tagNames = tags.split(",");      


        System.out.println("Step 2");
        
        
        for (String tagName : tagNames) {
        	Tag tag = (Tag) tagRepository.findByName(tagName);
            tagName = tagName.trim();
            if (!tagName.isEmpty()) {
                if (tag == null) {
                    tag = new Tag();
                    tag.setName(tagName);
                    tagRepository.save(tag);
                }
                tagList.add(tag);
                
                
            }
        }

        picture.setTags(tagList);

        pictureRepository.save(picture);

        System.out.println("Step 3");
        
        return "uploadPicture";
        
        }
        
    @GetMapping("/uploadPicturePage")
    public String showUploadPage() {
    	return "uploadPicture";
    }
    
    	/*make this later
    	
        @GetMapping("/searchByTag")
        public List<Picture> searchByTag(@RequestParam("tagName") String tagName) {
            List<Picture> pictures = pictureRepository.searchByTag(tagName);
            return pictures;
            
        //HTML code
        <form action="/searchByTag" method="get">
    	<label for="tagName">Enter Tag Name:</label>
    	<input type="text" id="tagName" name="tagName">
    	<button type="submit">Search</button>
		</form>*/
    
}
