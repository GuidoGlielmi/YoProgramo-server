package com.heroku.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.heroku.demo.Entities.Education;
import com.heroku.demo.Entities.Experiences;
import com.heroku.demo.Entities.ProjectUrl;
import com.heroku.demo.Entities.Projects;
import com.heroku.demo.Entities.Role;
import com.heroku.demo.Entities.Skills;
import com.heroku.demo.Entities.Technologies;
import com.heroku.demo.Entities.Users;
import com.heroku.demo.Services.EducationService;
import com.heroku.demo.Services.ExperienceService;
import com.heroku.demo.Services.ProjectService;
import com.heroku.demo.Services.SkillService;
import com.heroku.demo.Services.TechService;
import com.heroku.demo.Services.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}

	/* @Bean
	CommandLineRunner run(UserService userService, EducationService educationService, ExperienceService experienceService,
			ProjectService projectService, SkillService skillService, TechService techService) {
		return args -> {
			userService.addRole(new Role(null, "ADMIN"));
			userService.addRole(new Role(null, "USER"));
			userService.addUser(
					new Users(null, "guido", "password", "Guido", "Glielmi", "https://www.linkedin.com/in/guido-glielmi/",
							"https://github.com/GuidoGlielmi",
							"I live in Argentina, in the city of Rosario. I discovered -not so long ago- the programming world through microntrollers using the legendary C language, which from I developed a passion for automating and problem solving.",
							"/assets/img/profile-img.jpg",
							new ArrayList<>()));

			userService.addRoleToUser("guido", "ADMIN");
			educationService.addEducation(new Education(null, "Instituto Politécnico Superior", "04/2019", "Current",
					"Technician in Electronic Systems", "/assets/logos/IPS-UNR.png"));
			educationService.addEducation(new Education(null, "Universidad Nacional de Rosario - Escuela de Música",
					"04/2016", "11/2019", "Sound and Recording Technician", "/assets/logos/fhya.png"));
			experienceService.addExperience(new Experiences(null, "Radium Rocket", "MERN stack Bootcamp", "09/2021",
					"01/2022", "/assets/img/certificates/RR.jpg", "/assets/logos/RR.png"));
			experienceService.addExperience(new Experiences(null, "Argentina Programa", "Portfolio development", "11/2021",
					"05/2022", "", "/assets/logos/AP.png"));
			experienceService.addExperience(
					new Experiences(null, "Taller Corazón de Manzana", "Customer attention and inventory management", "02/2020",
							"06/2021", "", "/assets/logos/TCDM.jpg"));
			skillService.addSkill(new Skills(null, "Proactive", 80, "HardAndSoft"));
			skillService.addSkill(new Skills(null, "Active listening", 80, "HardAndSoft"));
			skillService.addSkill(new Skills(null, "Empathy", 80, "HardAndSoft"));
			skillService.addSkill(new Skills(null, "Creativity", 80, "HardAndSoft"));
			skillService.addSkill(new Skills(null, "Resilience", 80, "HardAndSoft"));
			skillService.addSkill(new Skills(null, "Español", 100, "language"));
			skillService.addSkill(new Skills(null, "English", 80, "language"));
			skillService.addSkill(new Skills(null, "日本語 / Japanese", 20, "language"));
			UUID angularID = techService
					.addTech(new Technologies(null, "Angular", "/assets/logos/angular.png", new ArrayList<>()));
			Technologies angular = techService.getTechById(angularID);
			UUID cssID = techService.addTech(new Technologies(null, "CSS3", "/assets/logos/css3.png", new ArrayList<>()));
			Technologies css = techService.getTechById(cssID);
			UUID expressID = techService
					.addTech(new Technologies(null, "Express.js", "/assets/logos/expressjs.png", new ArrayList<>()));
			Technologies express = techService.getTechById(expressID);
			UUID htmlID = techService.addTech(new Technologies(null, "HTML5", "/assets/logos/html5.png", new ArrayList<>()));
			Technologies html = techService.getTechById(htmlID);
			UUID javaID = techService.addTech(new Technologies(null, "Java", "/assets/logos/java.png", new ArrayList<>()));
			Technologies java = techService.getTechById(javaID);
			UUID javascriptID = techService
					.addTech(new Technologies(null, "Javascript", "/assets/logos/javascript.png", new ArrayList<>()));
			Technologies javascript = techService.getTechById(javascriptID);
			UUID mongoID = techService
					.addTech(new Technologies(null, "MongoDB", "/assets/logos/mongodb.png", new ArrayList<>()));
			Technologies mongo = techService.getTechById(mongoID);
			UUID nextID = techService
					.addTech(new Technologies(null, "Next.js", "/assets/logos/nextjs.png", new ArrayList<>()));
			Technologies next = techService.getTechById(nextID);
			UUID nodeID = techService
					.addTech(new Technologies(null, "Node.js", "/assets/logos/nodejs.png", new ArrayList<>()));
			Technologies node = techService.getTechById(nodeID);
			UUID postgreID = techService
					.addTech(new Technologies(null, "PostgreSQL", "/assets/logos/postgresql.png", new ArrayList<>()));
			Technologies postgre = techService.getTechById(postgreID);
			UUID springID = techService
					.addTech(new Technologies(null, "Redux", "/assets/logos/redux.png", new ArrayList<>()));
			Technologies spring = techService.getTechById(springID);
			UUID reactID = techService.addTech(new Technologies(null, "React", "/assets/logos/react.png", new ArrayList<>()));
			Technologies react = techService.getTechById(reactID);
			UUID reduxID = techService
					.addTech(new Technologies(null, "Spring", "/assets/logos/spring.png", new ArrayList<>()));
			Technologies redux = techService.getTechById(reduxID);
			UUID typescriptID = techService
					.addTech(new Technologies(null, "Typescript", "/assets/logos/typescript.png", new ArrayList<>()));
			Technologies typescript = techService.getTechById(typescriptID);

			List<Technologies> RRTechs = new ArrayList<Technologies>();
			RRTechs.add(css);
			RRTechs.add(html);
			RRTechs.add(javascript);
			RRTechs.add(node);
			RRTechs.add(mongo);
			RRTechs.add(express);
			RRTechs.add(react);
			RRTechs.add(redux);
			RRTechs.add(css);

			List<Technologies> aerolabTechs = new ArrayList<Technologies>();
			aerolabTechs.add(css);
			aerolabTechs.add(html);
			aerolabTechs.add(javascript);
			aerolabTechs.add(next);

			List<Technologies> APTechs = new ArrayList<Technologies>();
			APTechs.add(css);
			APTechs.add(html);
			APTechs.add(javascript);
			APTechs.add(java);
			APTechs.add(postgre);
			APTechs.add(spring);
			APTechs.add(angular);
			APTechs.add(typescript);
			Projects RR = projectService.addProject(new Projects(null, "Radium Rocket",
					"Development of a fictional enterprise that matches applicants with open jobs from client companies",
					"/assets/logos/RR.png", RRTechs, new ArrayList<ProjectUrl>()));
			projectService
					.addUrl(new ProjectUrl(null, "https://github.com/GuidoGlielmi/German-MindSet-app", "German-MindSet-app", RR,
							RR.getId()));
			projectService.addUrl(
					new ProjectUrl(null, "https://github.com/GuidoGlielmi/David-MindSet-server", "David-MindSet-server", RR,
							RR.getId()));
			projectService.addUrl(
					new ProjectUrl(null, "https://github.com/GuidoGlielmi/German-MindSet-server", "German-MindSet-server", RR,
							RR.getId()));

			Projects AP = projectService.addProject(new Projects(null, "Argentina Programa",
					"Portfolio development",
					"/assets/logos/AP.png", APTechs, new ArrayList<ProjectUrl>()));
			projectService
					.addUrl(new ProjectUrl(null, "https://github.com/GuidoGlielmi/YoProgramo-server", "YoProgramo-server", AP,
							AP.getId()));
			projectService
					.addUrl(new ProjectUrl(null, "https://github.com/GuidoGlielmi/YoProgramo-server", "YoProgramo-server", AP,
							AP.getId()));

			Projects aerolab = projectService.addProject(new Projects(null, "Aerolab challenge",
					"E-commerce landing page",
					"/assets/logos/aerolab.jpg", aerolabTechs, new ArrayList<ProjectUrl>()));

			projectService
					.addUrl(
							new ProjectUrl(null, "https://github.com/GuidoGlielmi/Aerolab-challenge", "Aerolab-challenge", aerolab,
									aerolab.getId()));

		};
	} */
}
