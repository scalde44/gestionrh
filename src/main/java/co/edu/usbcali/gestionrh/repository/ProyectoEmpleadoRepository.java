package co.edu.usbcali.gestionrh.repository;

import co.edu.usbcali.gestionrh.model.domain.ProyectoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoEmpleadoRepository extends JpaRepository<ProyectoEmpleado, Long> {
}