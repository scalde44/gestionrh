package co.edu.usbcali.gestionrh.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String abreviatura;

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = false, length = 20)
    private String nit;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContratoEmpleado> contratosEmpleados;

    public Empresa(String nombre, String abreviatura, String nit) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.nit = nit;
        this.estado = true;
        this.contratosEmpleados = new ArrayList<>();
    }

    public void inactivarEmpresa() {
        this.estado = false;
    }
}
