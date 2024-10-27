import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ConsultaService {
    private String archivoHistorial;
    private List<Consulta> historial;

    public ConsultaService(String archivoHistorial) {
        this.archivoHistorial = archivoHistorial;
        this.historial = cargarHistorial();
    }

    // Método para guardar una nueva consulta en el historial
    public void guardarConsulta(String monedaOrigen, String monedaDestino, double cantidad, double resultado) {
        Consulta nuevaConsulta = new Consulta(monedaOrigen, monedaDestino, cantidad, resultado);
        historial.add(nuevaConsulta);
        guardarHistorial();
    }

    // Método para mostrar el historial de conversiones
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay consultas registradas en el historial.");
        } else {
            System.out.println("Historial de conversiones:");
            for (Consulta consulta : historial) {
                System.out.println(consulta);
            }
        }
    }

    // Carga el historial desde el archivo JSON
    private List<Consulta> cargarHistorial() {
        try (FileReader reader = new FileReader(archivoHistorial)) {
            Type tipoLista = new TypeToken<ArrayList<Consulta>>() {}.getType();
            return new Gson().fromJson(reader, tipoLista);
        } catch (IOException e) {
            // Si el archivo no existe o hay un error, retornamos una lista vacía
            return new ArrayList<>();
        }
    }

    // Guarda el historial en el archivo JSON
    private void guardarHistorial() {
        try (FileWriter writer = new FileWriter(archivoHistorial)) {
            new Gson().toJson(historial, writer);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }
}

