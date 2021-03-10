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
    ":platform:logger"
)