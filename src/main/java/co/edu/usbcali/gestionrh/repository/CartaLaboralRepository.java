package co.edu.usbcali.gestionrh.repository;

import co.edu.usbcali.gestionrh.model.domain.CartaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaLaboralRepository extends JpaRepository<CartaLaboral, Long> {
}