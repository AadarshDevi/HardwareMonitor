package org.aadarshdevi.hardwaremonitor.backend.setup;

/**
 * a class that tracks version numbers
 */
public class Version {
    private final int majorVersion;
    private final int minorVersion;
    private final int patchVersion;

    public Version(int majorVersion, int minorVersion, int patchVersion) {
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.patchVersion = patchVersion;
    }

    public Version(String versionString) {
        String[] versions = versionString.split("\\.");
        majorVersion = Integer.parseInt(versions[0]);
        minorVersion = Integer.parseInt(versions[1]);
        patchVersion = Integer.parseInt(versions[2]);
    }

    @Override
    public String toString() {
        return majorVersion + "." + minorVersion + "." + patchVersion;
    }

    public boolean greaterThan(Version incoming) {
        if (this.majorVersion > incoming.majorVersion) {
            return true;
        }
        if (this.minorVersion > incoming.minorVersion) {
            return true;
        }
        return this.patchVersion > incoming.patchVersion;
    }
}
