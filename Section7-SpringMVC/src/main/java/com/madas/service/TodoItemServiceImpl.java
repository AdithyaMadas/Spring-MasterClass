package com.madas.service;

import com.madas.model.TodoData;
import com.madas.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoData todoData;

    public TodoItemServiceImpl() {
        todoData = new TodoData();
    }

    @Override
    public void addItem(TodoItem item) {
        todoData.addItem(item);
    }

    @Override
    public void removeItem(int id) {
        todoData.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return todoData.getItem(id);
    }

    @Override
    public void updateItem(TodoItem item) {
        todoData.updateId(item);
    }

    @Override
    public TodoData getData() {
        return todoData;
    }
}
