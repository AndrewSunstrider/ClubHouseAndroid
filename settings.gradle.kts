pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

include(
    ":app",
    ":features:auth",
    ":platform:domain",
    ":platform:logger",
    ":platform:networking",
    ":platform:persistence",
    ":platform:rest-clubhouse",
    ":platform:shared-assets",
    ":platform:shared-utilities"
)