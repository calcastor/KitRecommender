plugins {
    id("buildlogic.java-conventions")
}

dependencies {
    compileOnly(libs.app.ashcon.sportpaper)
    compileOnly(libs.tc.oc.pgm.core)
    compileOnly(libs.it.unimi.dsi.fastutil)
    compileOnly(libs.com.google.guava)
    compileOnly(libs.com.google.code.gson)
    compileOnly(libs.org.apache.commons.commons.lang3)
}

description = "KitUtil"
