package com.madas.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    // == Fields ==
    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    public TodoData() {
        addItem(new TodoItem("First", "First details", LocalDate.now()));
        addItem(new TodoItem("Second", "Second details", LocalDate.now()));
        addItem(new TodoItem("Third", "Third details", LocalDate.now()));
        addItem(new TodoItem("Fourth", "Fourth details", LocalDate.now()));
    }

    // == public methods
    public void addItem(@NonNull TodoItem item) {
        item.setId(idValue);
        items.add(item);
        idValue++;
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> iterator = items.listIterator();
        while (iterator.hasNext()) {
            TodoItem item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void updateId(@NonNull TodoItem item) {
        ListIterator<TodoItem> iterator = items.listIterator();
        while (iterator.hasNext()) {
            TodoItem itemFromList = iterator.next();
            if (item.equals(itemFromList)) {
                iterator.set(item);
                break;
            }
        }
    }
}
