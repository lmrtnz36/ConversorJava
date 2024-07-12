import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Map;

public class InterpreteJson {

    public InterpreteJson(){}

    public CambioMonedaData fromJson(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        var mapSerializado = conversionRates.asMap();
        CambioMonedaData cambioMonedaData = new CambioMonedaData();
        for (var key : mapSerializado.keySet())
        {
            double rate = conversionRates.get(key).getAsDouble();
            cambioMonedaData.agregarDatos(key, rate);
        }
        return cambioMonedaData;
    }
}
