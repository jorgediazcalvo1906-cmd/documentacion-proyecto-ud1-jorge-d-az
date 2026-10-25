package es.centro.incidencias;

import java.util.List;

/**
 * Esta clase se encarga de administrar las incidencias del centro educativo.
 * Permite listar, filtrar por estado, buscar por texto y localizar incidencias por su identificador.
 *
 * @author Jorge Díaz Calvo
 * @version 1.0.0
 * @since 1.0.0
 * @see Incidencia
 * @see IncidenciaNoEncontradaException
 */
public final class GestorIncidencias {

    private final List<Incidencia> incidencias;

    /**
     * Constructor que inicializa el gestor con un conjunto de incidencias de prueba.
     */
    public GestorIncidencias() {
        incidencias = List.of(
                new Incidencia("INC-001", "No se puede iniciar sesión", "alta", true),
                new Incidencia("INC-002", "Actualizar el navegador", "media", false),
                new Incidencia("INC-003", "Impresora sin conexión", "baja", true),
                new Incidencia("INC-004", "Fallo de red en el aula", "alta", true)
        );
    }

    /**
     * Devuelve la lista completa de todas las incidencias registradas.
     *
     * @return lista inmutable con todas las incidencias.
     */
    public List<Incidencia> listar() {
        return incidencias;
    }

    /**
     * Filtra y devuelve únicamente aquellas incidencias que se encuentran abiertas.
     *
     * @return lista de incidencias abiertas.
     */
    public List<Incidencia> listarAbiertas() {
        return incidencias.stream()
                .filter(Incidencia::isAbierta)
                .toList();
    }

    /**
     * Busca incidencias cuyo identificador o título contengan el texto especificado.
     *
     * @param texto cadena de texto a buscar dentro de las incidencias.
     * @return lista de incidencias que coinciden con el criterio de búsqueda.
     */
    public List<Incidencia> buscar(String texto) {
        return incidencias.stream()
                .filter(incidencia -> incidencia.coincideCon(texto))
                .toList();
    }

    /**
     * Busca una incidencia específica por su identificador único.
     *
     * @param id identificador único de la incidencia.
     * @return la instancia de {@link Incidencia} encontrada.
     * @throws IncidenciaNoEncontradaException si no existe ninguna incidencia con el identificador proporcionado.
     */
    public Incidencia buscarPorId(String id) throws IncidenciaNoEncontradaException {
        return incidencias.stream()
                .filter(incidencia -> incidencia.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new IncidenciaNoEncontradaException(id));
    }

    /**
     * Obtiene una incidencia por su identificador.
     *
     * @deprecated Este método ha quedado obsoleto. En su lugar, se recomienda utilizar
     *             {@link #buscarPorId(String)} para gestionar adecuadamente los errores mediante excepciones,
     *             o manejar los resultados filtrados mediante streams.
     *
     * @param id identificador único de la incidencia.
     * @return la {@link Incidencia} encontrada, o {@code null} si no se encuentra ninguna coincidencia.
     */
    @Deprecated(since = "1.0.0", forRemoval = false)
    public Incidencia obtenerIncidencia(String id) {
        try {
            return buscarPorId(id);
        } catch (IncidenciaNoEncontradaException excepcion) {
            return null;
        }
    }
}