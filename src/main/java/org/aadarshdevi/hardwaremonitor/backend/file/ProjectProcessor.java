package org.aadarshdevi.hardwaremonitor.backend.file;

import org.aadarshdevi.hardwaremonitor.backend.data.Project;

import java.nio.file.Path;

/**
 * Generates projects
 */
public class ProjectProcessor {
    private static ProjectProcessor instance;

    public static ProjectProcessor getInstance() {
        if (instance == null) instance = new ProjectProcessor();
        return instance;
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

    public void listProjects() {
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
