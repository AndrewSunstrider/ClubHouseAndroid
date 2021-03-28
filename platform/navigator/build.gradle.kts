
plugins {
    id(BuildPlugins.Ids.androidModule)
}

dependencies {
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.appCompat)
    implementation(Libraries.activity)
    implementation(Libraries.activityExtensions)
    implementation(Libraries.kodein)
    implementation(project(Modules.PLATFORM_SHARED_UTILITIES))

    testImplementation(project(Modules.PLATFORM_COROUTINES_TEST_UTILS))
    testImplementation(Libraries.roboletric)
    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.assertj)
}
