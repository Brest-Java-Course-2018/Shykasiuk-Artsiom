package com.epam.brest.course.web_app.controllers;

import com.epam.brest.course.model.dto.DepartmentDTO;
import com.epam.brest.course.model.Department;
import com.epam.brest.course.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

/**
 * Department controller.
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * Goto departments page.
     *
     * @return view name.
     */
    @GetMapping(value = "/departments")
    public final String getDepartmentById(Model model) {
        Collection<DepartmentDTO> departments =
                departmentService.getDepartmentsDTO();
        model.addAttribute("deps", departments);
        return "departments";
    }

    /**
     * Goto department page
     *
     * @return view name.
     */
    @GetMapping(value = "/department")
    public final String department(Model model) {
        model.addAttribute("type", "add");
        return "department";
    }

    /**
     * Goto department page.
     *
     * @param id department Id.
     * @return view name.
     */
    @GetMapping(value = "/department/{id}")
    public final String department(@PathVariable Integer id,
                                   Model model) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        model.addAttribute("type", "change");
        return "department";
    }

//    @RequestMapping
//    public final String getDeleteDepartment(@RequestParam("depId") int depId, Model model) {
//        departmentService.deleteDepartmentById(depId);
//        return "redirect:departments";
//    }
}
