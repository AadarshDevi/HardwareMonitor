package org.aadarshdevi.hardwaremonitor.backend.data;

import lombok.Data;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Project {

    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime opened;

    private String name;
    private List<Component> components;
    private List<String> commands;
    private Path path;

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
