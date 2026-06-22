package org.aadarshdevi.hardwaremonitor.backend.setup;

/**
 * Checks the user's device to determine the OS the user is using
 */
public class OperatingSystem {

    private static OperatingSystem operatingSystem;

    public static OSType getOS() {
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("win")) {
            return OSType.WINDOWS;
        } else if (osName.toLowerCase().contains("mac") || osName.toLowerCase().contains("darwin")) {
            return OSType.MACOS;
        } else if (osName.toLowerCase().contains("linux")) {
            return OSType.LINUX;
        }
        return null;
    }
//            PROJECTROOT = Paths.get(System.getenv("APPDATA")).resolve("FloatDataVisualizer").resolve(AppData.RELEASE_VERSION);
//            PROJECTROOT = Paths.get(System.getProperty("user.home")).resolve("Library").resolve("Application Support").resolve("FloatDataVisualizer").resolve(AppData.RELEASE_VERSION);
//            PROJECTROOT = Paths.get(System.getProperty("user.home")).resolve(".local").resolve("share").resolve("FloatDataVisualizer").resolve(AppData.RELEASE_VERSION);

    public static OperatingSystem getInstance() {
        if (operatingSystem == null) operatingSystem = new OperatingSystem();
        return operatingSystem;
    }

    public enum OSType {
        WINDOWS,
        MACOS,
        LINUX,
    }
}
