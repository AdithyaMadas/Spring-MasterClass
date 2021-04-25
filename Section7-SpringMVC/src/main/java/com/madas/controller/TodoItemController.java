package com.madas.controller;

import com.madas.model.TodoData;
import com.madas.model.TodoItem;
import com.madas.service.TodoItemService;
import com.madas.service.TodoItemServiceImpl;
import com.madas.utils.AttributeNames;
import com.madas.utils.Mappings;
import com.madas.utils.Views;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.time.LocalDate;
import java.util.Map;

@Slf4j
@Controller
public class TodoItemController {

    TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == Model Attributes ==
    @ModelAttribute("data123")
    public TodoData todoData123() {
        return todoItemService.getData();
    }

    //http://localhost:8080/Spring-MVC/items
    // == Handler Methods ==
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return Views.ITEMS;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model) {
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("Sample", "Sample", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return Views.ADD_ITEMS;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem = {}", todoItem);
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id, Model model) {
        log.info("Deleting todo with id: " + id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW)
    public String viewItem(@RequestParam int id, Model model) {
        log.info("View requested for id: {}", id);
        TodoItem item = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.ITEM, item);
        return Views.VIEW;
    }
}
