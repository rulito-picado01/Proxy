# Singleton, Proxy y Fachada

- Singleton:
    - **Propósito**: Permite asegurarnos de que una clase tenga una única instancia, a la vez que proporciona un punto de
      acceso global a dicha instancia.
    - Ojo con la sincronización en entornos multi thread.
- Proxy:
    - **Propósito**: permite proporcionar un **sustituto** para otro objeto. Un proxy controla el acceso
      al objeto original, permitiéndote hacer algo antes o después de que la solicitud llegue al objeto original.
    - **Proxy de protección**: controla el acceso al objeto original. Son útiles cuando los objetos debieran tener
      diferentes
      permisos de acceso.
    - **Proxy virtual**: Inicialización diferida. Retraza la creación de cierto objetos cuanto realizar esto es costoso.
    - **Proxy de caché**: permite guardar en caché resultados de solicitudes de clientes y gestionar el ciclo de vida de ese
      caché.
    - **Proxy de registro**: Es cuando quieres mantener un historial de solicitudes al objeto de servicio.
- Fachada:
    - **Propósito**: Proporcionar una interfaz unificada para un conjunto de interfaces de un subsistema, haciéndolo más
      fácil de usar.
    - Ejemplo de fachada, ese [objeto que representa el
      sistema](https://github.com/enriquemolinari/oop2-layering/blob/main/src/main/java/model/DefaultEstacionDeServicio.java).