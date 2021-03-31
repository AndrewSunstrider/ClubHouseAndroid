
plugins {
    id(BuildPlugins.Ids.kotlinModule)
}

dependencies {
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coroutinesCore)

    testImplementation(project(Modules.PLATFORM_COROUTINES_TEST_UTILS))
    testImplementation(Libraries.MOCKK)
    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.assertj)
    testImplementation(Libraries.burster)
}
