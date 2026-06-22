package org.aadarshdevi.hardwaremonitor.backend.file;

import org.aadarshdevi.hardwaremonitor.backend.data.Project;
import org.aadarshdevi.hardwaremonitor.backend.setup.ApplicationSettings;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Generates projects
 */
public class ProjectProcessor {
    private static ProjectProcessor instance;
    private final ApplicationSettings as;

    private ProjectProcessor() {
        as = ApplicationSettings.getInstance();
    }

    public static ProjectProcessor getInstance() {
        if (instance == null) instance = new ProjectProcessor();
        return instance;
    }

    public boolean findProject(Path projectPath) {
        // todo code
        return false;
    }

    public Project createProject(Path projectPath) {
        // create hwproj.config // config stuff
        // create hwproj.component // list of components
        // create hwproj.command // project specific settings
        return null; // fixme code
    }

    public Project openProject(Path projectPath) {
        // open a project
        return null; // fixme code
    }

    public void deleteProject(Path projectPath) {
        // delete project folder and contents
    }

    public void exportProject(Path projectPath, Path exportPath) {
        // export project
    }

    public Project importProject(Path projectPath, Path importPath) {
        // import project aka read and put project in projects folder
        return null; // fixme code
    }

    public void renameProject(Path projectPath, String newName) {
        // rename project
    }

    public Project readProject(Path projectPath) {
        // read project
        return null; // fixme code
    }

    public List<Project> listProjects() throws FileNotFoundException {
        List<Project> allProjects = new ArrayList<>();

        // files in /Documents
        File[] projects = new File(as.getProjectsRootFolder().toString()).listFiles();
        if (projects == null) {
            throw new FileNotFoundException("Unable to find Documents/HardwareMonitor folder");
        }
        for (File file : projects) {
            if (file.isFile()) {
                continue;
            }
            Project project = new Project();
            project.setName(file.getName());
            project.setPath(Path.of(file.getAbsolutePath()));
            allProjects.add(project);
        }

        // files in hardwaremonitor.projects
        try (BufferedReader reader = new BufferedReader(new FileReader(as.getExternalProjectsFile().toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Project project = new Project();
                String[] values = line.split(" ## ");

                if (!Files.exists(Path.of(values[1]))) {
                    continue;
                }

                project.setName(values[0].trim());
                project.setPath(Path.of(values[1].trim()));
                allProjects.add(project);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return allProjects;
    }
}
