/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_crud_no_rest;

/**
 *
 * @author sourav
 */
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController
{

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value =
    {
        "/", "/index", "/students"
    })
    public ModelAndView listStudents(String message)
    {
        List<Student> students = studentRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("students", students);
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/insert")
    public ModelAndView showInsertPage()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("insert");
        return modelAndView;
    }

    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Student s)
    {
        studentRepository.save(s);
        return listStudents("New Student was added successfully");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("id") String id)
    {
        long longId = Long.parseLong(id);
        String message = studentRepository.deleteById(longId);
        return listStudents(message);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam Map<String, String> json)
    {
        System.out.print("Json is : \n" + json);
        Long oldId = Long.parseLong(json.get("oldId"));
        Long newId = Long.parseLong(json.get("newId"));
        String name = json.get("name");
        long age = Long.parseLong(json.get("age"));
        Student s = new Student(newId, name, age);
        String message = studentRepository.update(oldId, s);
        return listStudents(message);
    }
}
