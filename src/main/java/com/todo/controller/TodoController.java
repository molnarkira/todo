package com.todo.controller;

import com.todo.entity.Todo;
import com.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTodo(@RequestParam String todo_name,
                           @RequestParam String todo_description){

        //megadom az adatokat
        Todo newTodo = new Todo();  //peldanyositas
        newTodo.setTitle(todo_name);
        newTodo.setDescription(todo_description);

        todoRepository.save(newTodo);   //ez elmenti

        return "redirect:";     //ez ujratolti az oldalam, visszakuldi az indexre(az alap oldalra)

    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    public String getTodo(@RequestParam String id,
                          Model model){
        Todo todo = todoRepository.findById(Integer.parseInt(id));       //a findById-ban int volt az idm, de itt már ugye String idt kérek be, ezért ez átalakítja a stringet intre...castolás

        model.addAttribute("todo", todo);   //itt a megtalalt todot odaadom a modelnek(nem MVCben a model)..mert ugye csak a modelel tudok átadni adatot a view-omnak..most a controllerben vagyok!!!
        return "todo";  //todo_html-t adja vissza
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteTodo(@RequestParam String id) {

        todoRepository.delete(todoRepository.findById(Integer.parseInt(id)));       //kitörli a megtalált idm-hez tartozo todot

        return "redirect: ";

    }
}
