import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectaApi {
    public Moneda buscarMoneda(String moneda, String convertir, double monto) {

        URI direccion = URI.create
                ("https://v6.exchangerate-api.com/v6/669c195dd1f959845572be17/pair/"
                        + moneda + "/" + convertir + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No fue posible encontrar el tipo de moneda, por favor intenta nuevamente");
        }
    }


}