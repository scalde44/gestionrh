package co.edu.usbcali.gestionrh.mapper;

import co.edu.usbcali.gestionrh.model.domain.Empresa;
import co.edu.usbcali.gestionrh.model.dto.EmpresaDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpresaMapper {

    public Empresa toEmpresaCreacion(EmpresaDto empresaDTO) {
        return Empresa.builder()
                .id(empresaDTO.getId())
                .nombre(empresaDTO.getNombre())
                .abreviatura(empresaDTO.getAbreviatura())
                .nit(empresaDTO.getNit())
                .estado(empresaDTO.getEstado())
                .build();
    }

    public EmpresaDto toEmpresaDto(Empresa empresa) {
        return EmpresaDto.builder()
                .id(empresa.getId())
                .nombre(empresa.getNombre())
                .abreviatura(empresa.getAbreviatura())
                .nit(empresa.getNit())
                .estado(empresa.getEstado())
                .build();
    }

    public List<EmpresaDto> toEmpresasDto(List<Empresa> empresas) {
        return empresas.stream()
                .map(this::toEmpresaDto)
                .toList();
    }
}
