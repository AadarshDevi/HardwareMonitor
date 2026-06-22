package org.aadarshdevi.hardwaremonitor.backend.file;

import org.aadarshdevi.hardwaremonitor.backend.data.Project;
import org.aadarshdevi.hardwaremonitor.backend.setup.ApplicationSettings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Generates projects
 */
public class ProjectProcessor {
    private static ProjectProcessor instance;

    public static ProjectProcessor getInstance() {
        if (instance == null) instance = new ProjectProcessor();
        return instance;
    }

    public void createProject() {
        // create hwproj.config // config stuff
        // create hwproj.component // list of components
        // create hwproj.command // project specific settings
    }

    public void deleteProject() {
        // delete project folder and contents
    }

    public void exportProject() {
        // export project
    }

    public void importProject() {
        // import project
    }

    public void renameProject() {
        // rename project
    }

    public void readProject() {
        // read project
    }

    public List<Project> listProjects() {
        // list projects
//        File projectsFile = new File(ApplicationSettings.getInstance().getExternalProjectsFile().toString());
//        List<Project> projects = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(projectsFile))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // todo code
//                Path path = Paths.get(line.split("##")[1].trim());
//                if (!path.toFile().exists() || !path.toFile().isDirectory()) {
//                    Files.createDirectories(path);
//                    continue;
//                }
//                System.out.println(path);
//                projects.add(new Project()); // fixme create a real project based on data
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return projects; // todo
    }
}
