package com.heroku.demo.Entities;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Technologies {
	@Id
	@GeneratedValue
	private UUID id;
	private String name = "";
	@JsonIgnore // This avoids recursion, can't be transfered via http
	@ManyToMany(mappedBy = "techs") //the mapped entity is NOT the owner,
	//so, when deleting, it's necessary to delete it from all the users and from the techs itself
	private List<Projects> projects = new ArrayList<Projects>();

	public Technologies() {
	}

	public Technologies(UUID id, String name) {
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Projects> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}

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
