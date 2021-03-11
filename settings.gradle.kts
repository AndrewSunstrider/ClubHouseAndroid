pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

include(
    ":app",
    ":features:auth",
    ":platform:coroutines-testutils",
    ":platform:domain",
    ":platform:logger",
    ":platform:navigator",
    ":platform:networking",
    ":platform:persistence",
    ":platform:rest-clubhouse",
    ":platform:shared-assets",
    ":platform:shared-utilities"
)