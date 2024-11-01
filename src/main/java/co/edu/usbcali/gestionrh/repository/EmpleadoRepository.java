package co.edu.usbcali.gestionrh.repository;

import co.edu.usbcali.gestionrh.model.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}