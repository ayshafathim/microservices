package com.UST.departmentservice.controller;

import com.UST.departmentservice.entity.Department;
import com.UST.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @PostMapping("/")
    public Department saveByDepartmentBId(@RequestBody Department department){
        return service.saveByDepartmentId(department);
    }
    @GetMapping("/{id}")
    public Department findByDepartmentId(@PathVariable("id")Long departmentId){
        return service.findByDepartmentId(departmentId);
    }
}
