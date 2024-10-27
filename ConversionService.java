import java.io.IOException;

public class ConversionService {
    private APIService apiService;
    private ConsultaService consultaService;

    public ConversionService(APIService apiService, ConsultaService consultaService) {
        this.apiService = apiService;
        this.consultaService = consultaService;
    }

    public double realizarConversion(String monedaOrigen, String monedaDestino, double cantidad) throws IOException, InterruptedException {
        double resultado = apiService.GestionDeConsulta(monedaOrigen, monedaDestino, cantidad);
        consultaService.guardarConsulta(monedaOrigen, monedaDestino, cantidad, resultado);
        return resultado;
    }
}

