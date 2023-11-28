package com.project.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String title;
private String description;

@ManyToOne
@JoinColumn(name = "id")
private User username;

@ManyToMany
@JoinTable(
	name = "tags",
	joinColumns = @JoinColumn(name = "picture_id"),
	inverseJoinColumns = @JoinColumn(name = "tag_id")
		)

	private List<Tag> tags;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
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
	return username;
}
//might need to look at this again later
public void setUser(User user) {
	this.username = user;
}

}
