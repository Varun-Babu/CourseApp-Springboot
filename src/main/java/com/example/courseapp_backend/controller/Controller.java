package com.example.courseapp_backend.controller;

import com.example.courseapp_backend.dao.CourseDao;
import com.example.courseapp_backend.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private CourseDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String AddCourse(@RequestBody Courses c){
        System.out.println(c.getCourseTitle());
        System.out.println(c.toString());
        dao.save(c);
        return "add";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Courses> ViewCourse(){
        return (List<Courses>) dao.findAll();
    }



}
