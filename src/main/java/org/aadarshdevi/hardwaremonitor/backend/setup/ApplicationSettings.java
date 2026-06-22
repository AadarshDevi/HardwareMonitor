package org.aadarshdevi.hardwaremonitor.backend.setup;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;

public class ApplicationSettings {
    private static ApplicationSettings instance;
    @Setter
    @Getter
    private final Version version = new Version("0.1.0");
    @Setter
    @Getter
    private OperatingSystem.OSType operatingSystem;
    @Setter
    @Getter
    private Path appRootFolder;
    @Setter
    @Getter
    private Path projectsRootFolder;
    @Setter
    @Getter
    private Path settingsFile;
    @Setter
    @Getter
    private Path logFile;
    @Setter
    @Getter
    private Path componentsFolder;
    @Setter
    @Getter
    private Path externalProjectsFile;

    public static ApplicationSettings getInstance() {
        if (instance == null) instance = new ApplicationSettings();
        return instance;
    }
}
