package com.project.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer picture_id;
private String title;
private String description;

@ManyToOne
@JoinColumn(name = "user_id")
private User user;

@ManyToMany
@JoinTable(
	name = "tags",
	joinColumns = @JoinColumn(name = "picture_id"),
	inverseJoinColumns = @JoinColumn(name = "tag_id")
		)

	private List<Tag> tags;

public Integer getId() {
	return picture_id;
}

public void setId(Integer id) {
	this.picture_id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public User getUser() {
	return user;
}
//might need to look at this again later
public void setUser(User user) {
	this.user = user;
}

}
