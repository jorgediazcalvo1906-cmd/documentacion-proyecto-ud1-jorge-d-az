package es.centro.incidencias;

import java.util.Locale;

/**
 * Representa una incidencia dentro del centro educativo.
 * Cada incidencia contiene un identificador, un título, un nivel de prioridad
 * y un indicador booleano de si esta abierta o cerrada.
 *
 * @author Jorge Díaz Calvo
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Incidencia {

    private final String id;
    private final String titulo;
    private final String prioridad;
    private final boolean abierta;

    /**
     * Constructor para inicializar una nueva incidencia con todos sus atributos.
     *
     * @param id        identificador único de la incidencia.
     * @param titulo    descripción breve o título del problema reportado.
     * @param prioridad nivel de prioridad de la incidencia.
     * @param abierta   estado de la incidencia: {@code true} si está abierta, {@code false} si está cerrada.
     */
    public Incidencia(String id, String titulo, String prioridad, boolean abierta) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.abierta = abierta;
    }

    /**
     * Devuelve el identificador único de la incidencia.
     *
     * @return el identificador en formato {@link String}.
     */
    public String getId() {
        return id;
    }

    /**
     * Devuelve el título o descripción breve de la incidencia.
     *
     * @return el título en formato {@link String}.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el nivel de prioridad asignado a la incidencia.
     *
     * @return la prioridad como {@link String}.
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Indica si la incidencia se encuentra abierta.
     *
     * @return {@code true} si está abierta, {@code false} en caso contrario.
     */
    public boolean isAbierta() {
        return abierta;
    }

    /**
     * Comprueba si el identificador o el título de la incidencia coinciden con un texto de búsqueda.
     *
     * @param texto cadena de texto a buscar.
     * @return {@code true} si el texto está contenido en el identificador o en el título; {@code false} en caso contrario.
     */
    public boolean coincideCon(String texto) {
        String criterio = texto.toLowerCase(Locale.ROOT);
        return id.toLowerCase(Locale.ROOT).contains(criterio)
                || titulo.toLowerCase(Locale.ROOT).contains(criterio);
    }

    /**
     * Devuelve una representación en cadena de texto formateada de la incidencia.
     *
     * @return cadena con la información detallada de la incidencia.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s (Prioridad: %s) - %s",
                id, titulo, prioridad, abierta ? "ABIERTA" : "CERRADA");
    }
}