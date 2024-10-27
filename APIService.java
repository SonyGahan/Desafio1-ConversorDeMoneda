import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class APIService {
    private String urlBase = "https://v6.exchangerate-api.com/v6/";
    //Ingrese aqui su propia claveApi
    private String claveApi = "";

    public double GestionDeConsulta(String monedaDeOrigen, String monedaDestino, double cantidad) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBase + claveApi + monedaDeOrigen))  // Armo la ruta de conexion a la API
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);

        // Accedemos al campo "conversion_rates" de la API y luego obtenemos la tasa de la moneda destino
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
        double tasaDeCambio = conversionRates.get(monedaDestino).getAsDouble();

        return cantidad * tasaDeCambio;
    }
}



