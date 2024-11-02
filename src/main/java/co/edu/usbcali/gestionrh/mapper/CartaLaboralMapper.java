package co.edu.usbcali.gestionrh.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.usbcali.gestionrh.model.domain.CartaLaboral;
import co.edu.usbcali.gestionrh.model.dto.CartaLaboralDTO;

@Component
public class CartaLaboralMapper {
  public static CartaLaboralDTO toDTO (CartaLaboral cartaLaboral) {
    return CartaLaboralDTO.builder()
      .id(cartaLaboral.getId())
      .idEmpleado(
        cartaLaboral.getEmpleado() == null ? null : cartaLaboral.getEmpleado().getId()
      )
      .entidadDestino(cartaLaboral.getEntidadDestino())
      .fecha(cartaLaboral.getFecha())
      .build();
  }

  public static CartaLaboral toDomain (CartaLaboralDTO cartaLaboralDTO) {
    return CartaLaboral.builder()
      .id(cartaLaboralDTO.getId())
      /*.empleado(
        cartaLaboralDTO.getEmpleado() == null ? null : cartaLaboralDTO.getEmpleado().getId()
      )*/
      .entidadDestino(cartaLaboralDTO.getEntidadDestino())
      .fecha(cartaLaboralDTO.getFecha())
      .build();
  }

  public static List<CartaLaboralDTO> toDTOList(List<CartaLaboral> cartaLaborals) {
    return cartaLaborals.stream().map(CartaLaboralMapper::toDTO).toList();
  }

  public static List<CartaLaboral> toDomainList(List<CartaLaboralDTO> cartaLaboralDTOs) {
    return cartaLaboralDTOs.stream().map(CartaLaboralMapper::toDomain).toList();
  }
}
