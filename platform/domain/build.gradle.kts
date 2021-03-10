
plugins {
    id(BuildPlugins.Ids.kotlinModule)
}

dependencies {
    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.coroutinesCore)

    testImplementation(Libraries.jUnit)
    testImplementation(Libraries.assertj)
    testImplementation(Libraries.burster)
}
