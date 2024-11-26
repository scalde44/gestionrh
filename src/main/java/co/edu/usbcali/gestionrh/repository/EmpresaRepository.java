package co.edu.usbcali.gestionrh.repository;

import co.edu.usbcali.gestionrh.model.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Boolean existsByNit(String nit);

    Boolean existsByIdNotAndNit(Long id, String nit);
}