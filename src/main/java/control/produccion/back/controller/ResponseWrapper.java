package control.produccion.back.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
public class ResponseWrapper<T> {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T datos;
    private String mensaje;
    private int estado;

    //Aquí solo nos interesa envolver y devolver los datos y un mensaje de éxito
    public static <T> ResponseWrapper<T> exito(T datos, String mensaje) {
        ResponseWrapper<T> response = new ResponseWrapper<>();
        response.setDatos(datos);
        response.setMensaje(mensaje);
        response.setEstado(200);

        return response;
    }

    //Aquí nos interesa devolver un mensaje de error y el estado (código)
    public static <T> ResponseWrapper<T> error (String mensaje, int estado) {
        ResponseWrapper<T> response = new ResponseWrapper<>();
        response.setMensaje(mensaje);
        response.setEstado(estado);

        return response;
    }

    //ResponseEntity es una clase que representa a una respuesta HTTP completa
    public ResponseEntity<?> toResponseEntity() { // ? Indica que puede envolver cuálquier tipo de dato
        return ResponseEntity.status(estado).body(this); // Este objeto (ResponseWrapper) será convertido en ResponseEntity
    }
}
