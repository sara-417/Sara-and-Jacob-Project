package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mapper.PictureRepository;
import com.project.mapper.TagRepository;
import com.project.mapper.UserRepository;
import com.project.model.Picture;
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

        // Create a new Picture object
        Picture picture = new Picture();
        picture.setUser(username);
        picture.setTitle(title);
        picture.setDescription(description);

        // Split the tags string into individual tag names
        String[] tagNames = tags.split(",");

        // Create a list to store the tags associated with the picture
        List<Tag> pictureTags = new ArrayList<>();

        // Iterate over the tag names and create tags or retrieve existing ones
        for (String tagName : tagNames) {
            tagName = tagName.trim(); // Remove leading/trailing spaces
            if (!tagName.isEmpty()) { // Skip empty tag names
                Tag tag = tagRepository.findByName(tagName);
                if (tag == null) {
                    // If the tag doesn't exist, create a new one
                    tag = new Tag();
                    tag.setName(tagName);
                    tagRepository.save(tag);
                }
                pictureTags.add(tag);
            }
        }

        // Set the tags for the picture
        picture.setTags(pictureTags);

        // Save the picture to the database
        pictureRepository.save(picture);

        // Return a simple success message
        return "Picture uploaded successfully!";
    }
}
