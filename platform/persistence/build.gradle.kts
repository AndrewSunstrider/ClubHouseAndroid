
plugins {
    id(BuildPlugins.Ids.androidModule)
}

dependencies {
    implementation(project(Modules.PLATFORM_DOMAIN))
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.kodein)

    testImplementation(project(Modules.PLATFORM_COROUTINES_TEST_UTILS))
    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.assertj)
}
