package control.produccion.back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuarios", schema = "seguridad")
@Getter @Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", nullable = false)
    private String nombreUsuario;

    @Column(name = "clave_usuario", nullable = false)
    private String claveUsuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false) // esta columna es clave foránea
    private Rol rol;
}
