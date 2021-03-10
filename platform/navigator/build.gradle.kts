
plugins {
    id(BuildPlugins.Ids.androidModule)
}

dependencies {
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.appCompat)
    implementation(Libraries.activity)
    implementation(Libraries.activityExtensions)
    implementation(Libraries.kodein)
    implementation(project(":platform:shared-utilities"))

    testImplementation(Libraries.roboletric)
    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.assertj)
}
