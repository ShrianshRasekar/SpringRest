package com.example.springrest.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(1,"core java","basics of java"));
		list.add(new Course(2,"Adv java","J2EE of java"));
		
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	
	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course deleteCourse(long courseId) {
		//Course c=null;
		list.remove(courseId);
		
		return  (Course) list;
	}

	
}	

;