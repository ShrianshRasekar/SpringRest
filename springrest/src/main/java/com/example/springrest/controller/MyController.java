package com.example.springrest.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrest.entities.Course;
import com.example.springrest.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseservice;
	
	@GetMapping("/home")
	public String home() {
		return "this is home";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.courseservice.getCourses();
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping(path="/course")
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public Course deleteCourse(@PathVariable String courseId) {
		return this.courseservice.deleteCourse(Long.parseLong(courseId));
	}
}
