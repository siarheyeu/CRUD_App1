package ru.siarheyeu.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.siarheyeu.springcourse.dao.PersonDAO;

@Controller
@RequestMapping("/test-batch-update")
public class BathController {



    private final PersonDAO personDAO;

    @Autowired
    public BathController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(){
        return "batch/index";
    }

    @GetMapping("without")
    public String withoutBatch(){
        personDAO.testMultipleUpdate();
        return "redirect:/people";
    }

    @GetMapping("with")
    public String withoutBatch(){
        personDAO.testBatchUpdate();
        return "redirect:/people";
    }


}
