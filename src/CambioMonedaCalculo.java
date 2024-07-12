import java.util.HashMap;

public class CambioMonedaCalculo {

    private double m_montoCambiado=0;

    public double getM_montoCambiado() {
        return m_montoCambiado;
    }

    public  CambioMonedaCalculo(String monedaActual, String monedaACambiar,
                                double montoActual,
                                HashMap<String, Double> data )
    {
        m_montoCambiado =
                montoActual*(1/data.get(monedaActual))*(data.get(monedaACambiar));
    }


}
