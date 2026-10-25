package es.centro.incidencias;

/**
 * Excepción personalizada que se lanza cuando se intenta buscar o consultar
 * una incidencia mediante un identificador que no existe.
 *
 * @author Jorge Díaz Calvo
 * @version 1.0.0
 * @since 1.0.0
 * @see GestorIncidencias#buscarPorId(String)
 */
public class IncidenciaNoEncontradaException extends Exception {

    /**
     * Constructor que inicializa la excepción con un mensaje detallado indicando el ID no encontrado.
     *
     * @param id identificador de la incidencia que provocó el error.
     */
    public IncidenciaNoEncontradaException(String id) {
        super("No existe ninguna incidencia con el identificador " + id + ".");
    }
}