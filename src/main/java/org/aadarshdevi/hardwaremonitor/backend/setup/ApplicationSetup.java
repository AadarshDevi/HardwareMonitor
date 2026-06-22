package org.aadarshdevi.hardwaremonitor.backend.setup;

import org.aadarshdevi.hardwaremonitor.backend.data.Project;
import org.aadarshdevi.hardwaremonitor.backend.setup.exception.OperatingSystemNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ApplicationSetup {
    private static ApplicationSetup instance;
    private final ApplicationSettings settings;

    public ApplicationSetup() {
        this.settings = ApplicationSettings.getInstance();
    }

    public static ApplicationSetup getInstance() {
        if (instance == null) instance = new ApplicationSetup();
        return instance;
    }

    public void findRoots() throws IOException {

        Path appRoot = switch (settings.getOperatingSystem()) {
            case WINDOWS -> Paths.get(System.getenv("APPDATA"), "HardwareMonitor", settings.getVersion().toString());
            case MACOS ->
                    Paths.get(System.getProperty("user.home"), "Library", "Application Support", "HardwareMonitor", settings.getVersion().toString());
            case LINUX ->
                    Paths.get(System.getProperty("user.home"), ".local", "share", "HardwareMonitor", settings.getVersion().toString());
        };

        createFolder(appRoot);
        settings.setAppRootFolder(appRoot);
        IO.println("App Root: " + settings.getAppRootFolder());

        Path projectsRoot = Paths.get(System.getProperty("user.home"), "Documents", "HardwareMonitor");
        createFolder(projectsRoot);
        settings.setProjectsRootFolder(projectsRoot);
        IO.println("Project Root: " + settings.getProjectsRootFolder());

        Path externalProjectsFile = settings.getAppRootFolder().resolve("hardwaremonitor.projects");
        createFile(externalProjectsFile);
        settings.setExternalProjectsFile(externalProjectsFile);
        IO.println("External Projects File: " + externalProjectsFile);
    }

    public void findOS() {
        OperatingSystem.getInstance();
        OperatingSystem.OSType os = OperatingSystem.getOS();
        if (os == null) {
            throw new OperatingSystemNotFoundException("Unable to find the Operating System of user: " + System.getProperty("user.name"));
        }
        settings.setOperatingSystem(os);
        IO.println("Operating System: " + os);
    }

    public void findSettings() throws FileNotFoundException {
        String filename = "hardwaremonitor.settings";
        Path settingsFile = settings.getAppRootFolder().resolve(filename);
        try {
            createFile(settingsFile);
            IO.println("App Settings: " + settingsFile);

            if (new File(settingsFile.toString()).length() == 0) {
                generateSettings();
            }

        } catch (IOException e) {
            throw new FileNotFoundException("Unable to find " + filename);
        }
        settings.setSettingsFile(settingsFile);
    }

    private void generateSettings() {
        // todo generate content of settings file
        IO.println(" > Generated Settings");
    }

    public void createFile(Path file) throws IOException {
        if (!Files.exists(file)) {
            Files.createFile(file);
        }
    }

    public void createFolder(Path folder) throws IOException {
        if (!Files.exists(folder)) {
            Files.createDirectories(folder);
        }
    }

    public void findComponents() throws FileNotFoundException {
        Path componentsFolder = settings.getAppRootFolder().resolve("components");
        try {
            createFolder(componentsFolder);
            IO.println("Component Folder: " + componentsFolder);
            File folder = new File(componentsFolder.toString());
            if (folder.listFiles() == null || folder.listFiles().length == 0) {
                generateComponents();
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Unable to create /components");
        }
        settings.setComponentsFolder(componentsFolder);
    }

    private void generateComponents() {
        // todo generate components
        IO.println(" > Generated Components");
    }

    public void findLog() throws FileNotFoundException {
        String filename = "hardwaremonitor.logs";
        Path logFile = settings.getAppRootFolder().resolve(filename);
        try {
            createFile(logFile);
            IO.println("Log File: " + logFile);

            if (new File(logFile.toString()).length() == 0) {
                generateSettings();
            }

        } catch (IOException e) {
            throw new FileNotFoundException("Unable to find " + filename);
        }
        settings.setLogFile(logFile);
    }

    public List<Project> getProjects() {
//        return ProjectProcessor.getInstance().listProjects();
        return null; // fixme (above)
    }
}
