plugins {
    id("io.github.bizcub.multiloader")
}

multiloader {
    setMREnvironment(mrEnvs.serverOnly)
    setCFEnvironment(cfEnvs.server)

    versionRange(version = "26.1.2", to = "latest")
    versionRange(version = "1.21.3", to = "1.21.11")
    versionRange(version = "1.21.1", from = "1.21", loader = "neoforge")
    versionRange(version = "1.21.1", from = "1.20.6", loader = "forge")
    versionRange(version = "1.21.1", from = "1.20.5")
    versionRange(version = "1.20.1", to = "1.20.4")

    addDependency(
        dependency = getSimpleConfigLibDep(),
        isPublishDepEnabled = true
    )

    if (isFabric) {
        addDependency(
            dependency = "net.fabricmc:fabric-loader:${getDep("fabric")}"
        )
        addDependency(
            dependency = "net.fabricmc.fabric-api:fabric-api:${getDep("fabric-api")}"
        )
        addDependency(
            dependency = "com.terraformersmc:modmenu:${getDep("modmenu")}",
            repository = "maven.terraformersmc.com/releases",
            excludedModules = listOf("eu.pb4"),
            isPublishDepEnabled = true
        )
    }
}
