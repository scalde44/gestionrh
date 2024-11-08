package co.edu.usbcali.gestionrh.repository;

import co.edu.usbcali.gestionrh.model.domain.ContratoEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoEmpleadoRepository extends JpaRepository<ContratoEmpleado, Long> {
}