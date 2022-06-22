import java.net.ConnectException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

// Works on static website, but doesnt on websites made with frontend framerworks
// Since we dont actually render any components
fun main(args: Array<String>){  
    if (args.size <= 0) {
        println("No website given!")
        return
    }

    val client = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create(args[0]))
        .build();
    try {
        val response = client.send(request, HttpResponse.BodyHandlers.ofString());
        val regex = Regex("<div+.*?\\/?>")
        println("Number of 'div' tags at ${args[0]}: ${regex.findAll(response.body()).count()}")
    } catch (e: ConnectException) {
        println("Connection failed!\nMake sure that URL is correct!")
    }
}