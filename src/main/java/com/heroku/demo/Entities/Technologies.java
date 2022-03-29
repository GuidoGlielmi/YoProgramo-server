package com.heroku.demo.Entities;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technologies {
	@Id
	@GeneratedValue
	private UUID id;
	private String name = "";
	private String techImg = "";
	@JsonIgnore // This avoids recursion, can't be transfered as JSON
	@ManyToMany(mappedBy = "techs") //the mapped entity is NOT the owner,
	//so, when deleting, it's necessary to delete it from all the users and from the techs itself.
	// I wouldn't make much sense to have CascadeType.REMOVE in a ManyToMany relationship, since it would delete every project that has the tech.
	private List<Projects> projects = new ArrayList<Projects>();

	public void addProject(Projects project) {
		this.projects.add(project);
	}

	public List<UUID> getProjectsId() {
		List<UUID> projectsId = new ArrayList<>();
		for (Projects project : projects) {
			projectsId.add(project.getId());
		}
		return projectsId;
	}

}
