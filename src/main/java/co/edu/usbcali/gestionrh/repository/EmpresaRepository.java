package co.edu.usbcali.gestionrh.repository;

import co.edu.usbcali.gestionrh.model.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}