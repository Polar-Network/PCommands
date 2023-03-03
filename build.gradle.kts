plugins {
    id("java")
}

group = "net.polar"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.Polar-Network:Polaroid:-SNAPSHOT")
}