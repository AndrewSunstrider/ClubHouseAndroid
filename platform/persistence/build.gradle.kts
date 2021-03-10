
plugins {
    id(BuildPlugins.Ids.androidModule)
}

dependencies {

    implementation(project(":platform:domain"))
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.kodein)

    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.assertj)
}
