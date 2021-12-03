package luke.day02

import luke.Luke
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths



class Day02: Luke() {
    override fun day() = 2

    override fun title() ="Polyline Coordinate Message"


    override fun run() {
        println("PST{mange snille barn i verden}")


        // Read coordinates
        val fileName = "src\\main\\kotlin\\luke\\day02\\huskelapp_til_2021.txt"
        var input = File(fileName).readText()

        // Split input
        val values = input
            .trim() // remove any trailing whitespace
            .drop(2) // drop the firs two characters [[
            .dropLast(2) // drop the firs two characters ]]
            .split("], [") // create a list entry for every coordinate
            .filter { it.isNotBlank() } // remove blank coordinate entries, thus []

        // Create CSV file
        var csvLines = values.mapIndexed { index, coordinates ->
            val (x, y) = coordinates.split(", ")

            "$x,$y,$index"
        }

        // Add header
        val csvLinesWithHeader = listOf("latitude,longitude,title") + csvLines

        // Write CSV file
        val resultFilePath: Path = Paths.get("src\\main\\kotlin\\luke\\day02\\huskelapp_til_2021.csv")
        Files.write(resultFilePath, csvLinesWithHeader)

        // The file can be uploaded here: mymaps.google.com

    }

    /*
    fun arrayToCSV(){
        /* In order to use this function add the following ot build.gradle.kts
        plugins {
            kotlin("jvm") version "1.5.31" // or kotlin("multiplatform") or any other kotlin plugin
            kotlin("plugin.serialization") version "1.5.31"
        }

        dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
        }

        Then import in class:
        import kotlinx.serialization.decodeFromString
        import kotlinx.serialization.json.Json
        */

        // Read coordinates
        val fileName = "src\\main\\kotlin\\luke\\day02\\huskelapp_til_2021.txt"
        var input = File(fileName).readText()


        val coordinateEntries: List<List<Double>> = Json.decodeFromString(input)
        val csvLines = coordinateEntries
            .filter { it.isNotEmpty() }
            .mapIndexed { index, coordinates ->
                val (x, y) = coordinates

                "$x,$y,$index"
            }

        val resultFilePath: Path = Paths.get("/tmp/example.txt")
        Files.write(resultFilePath, csvLines)
    }*/
}