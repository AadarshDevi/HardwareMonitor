package org.aadarshdevi.hardwaremonitor.backend.data;

import java.time.LocalDateTime;
import java.util.List;

public class Project {

    LocalDateTime created;
    LocalDateTime modified;
    LocalDateTime opened;

    String name;
    List<Component> components;
    List<String> commands;

    public Project() {
        /*
        check if folder exists
         */
    }

    boolean validName(String name) {
        // todo check if the project name is valid
        return false;
    }

    void addCommand(String command) {
        // todo write better code
        this.commands.add(command);
    }

    void removeCommand(String command) {
        // todo write better code
        this.commands.remove(command);
    }

    void addComponent(Component component) {
        // todo write better code
        this.components.add(component);
    }

    void removeComponent(Component component) {
        // todo write better code
        this.components.remove(component);
    }
}
