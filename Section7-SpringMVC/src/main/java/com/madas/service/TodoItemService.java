package com.madas.service;

import com.madas.model.TodoData;
import com.madas.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem item);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem item);

    TodoData getData();

}
