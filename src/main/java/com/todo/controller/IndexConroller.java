package com.todo.controller;


import com.todo.entity.Todo;
import com.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexConroller {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)        //mappel a / jelre (indexet fogja visszaadni)
    public String index(Model model){//ez gyujt a modellbol es a viewbol dolgokat, es azt adja vissza nekunk..a felso

        List<Todo> todos = todoRepository.findAll();        //lekerem az osszes peldanyomat

        model.addAttribute("todos", todos);     //megadtam a nevet es az erteket

        return "index";
    }
}
