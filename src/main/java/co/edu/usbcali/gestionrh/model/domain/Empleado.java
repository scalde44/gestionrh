package co.edu.usbcali.gestionrh.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_profesion", nullable = false)
    private Profesion profesion;

    @Column(nullable = false, length = 50)
    private String nombres;

    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(nullable = false, length = 150)
    private String correo;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column(nullable = false)
    private Boolean estado;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 1)
    private String genero;

    @Column(name = "tipo_identificacion", nullable = false, length = 50)
    private String tipoIdentificacion;

    @Column(name = "numero_identificacion", nullable = false, length = 50)
    private String numeroIdentificacion;

    @Column(nullable = false, length = 15)
    private String telefono;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartaLaboral> cartasLaborales;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContratoEmpleado> contratos;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProyectoEmpleado> proyectos;

    @OneToMany(mappedBy = "lider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProyectoEmpleado> liderProyectos;
}
