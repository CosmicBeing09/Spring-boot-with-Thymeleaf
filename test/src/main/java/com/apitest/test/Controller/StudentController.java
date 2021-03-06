package com.apitest.test.Controller;

import com.apitest.test.Model.Student;
import com.apitest.test.utils.StudentUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult errors, Model model) {
        if (!errors.hasErrors()) {
            // get mock objects
            List<Student> students = StudentUtils.buildStudents();
            // add current student
            students.add(student);
            model.addAttribute("students", students);
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getGender());
            System.out.println(student.getPercentage());
        }
        return ((errors.hasErrors()) ? "index.html" : "index.html");
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "index.html";
    }

}
