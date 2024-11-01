package co.edu.usbcali.gestionrh.mapper;

import co.edu.usbcali.gestionrh.model.domain.Empresa;
import co.edu.usbcali.gestionrh.model.dto.EmpresaDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpresaMapper {

    public Empresa toEmpresaCreacion(EmpresaDto empresaDTO) {
        return new Empresa(empresaDTO.getNombre(), empresaDTO.getAbreviatura(), empresaDTO.getNit());
    }

    public EmpresaDto toEmpresaDto(Empresa empresa) {
        return new EmpresaDto(empresa.getId(), empresa.getNombre(), empresa.getAbreviatura(), empresa.getNit(), empresa.getEstado());
    }

    public List<EmpresaDto> toEmpresasDto(List<Empresa> empresas) {
        return empresas.stream()
                .map(this::toEmpresaDto)
                .toList();
    }
}
