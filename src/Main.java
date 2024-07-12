import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;


public class Main {
    public static void main(String[] args)  throws IOException , InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(
                URI.create("https://v6.exchangerate-api.com/v6/3dc731b6ead7d6d11903710d/latest/USD")).build();

        HttpResponse<String> response = client.
                send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        InterpreteJson interprete = new InterpreteJson();
        CambioMonedaData monedaData = interprete.fromJson(json);
        var dataMoneda = monedaData.obtenerData();
        //CambioMonedaData data = new CambioMonedaData();

        Menu menu = new Menu();
        menu.mostrarInterfazUsuario(dataMoneda);
        CambioMonedaCalculo cambioMonedaCalculo = new CambioMonedaCalculo(
                menu.getM_monedaActual(),menu.getM_monedaACambiar(),
                menu.getM_monto(),dataMoneda);
        double montoCambiado = cambioMonedaCalculo.getM_montoCambiado();
        menu.MostrarResultados(montoCambiado);
    }
}