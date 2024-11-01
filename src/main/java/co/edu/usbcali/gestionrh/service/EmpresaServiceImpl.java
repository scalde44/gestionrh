package co.edu.usbcali.gestionrh.service;

import co.edu.usbcali.gestionrh.mapper.EmpresaMapper;
import co.edu.usbcali.gestionrh.model.domain.Empresa;
import co.edu.usbcali.gestionrh.model.dto.EmpresaDto;
import co.edu.usbcali.gestionrh.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository repository;
    private final EmpresaMapper mapper;

    @Transactional
    @Override
    public void crear(EmpresaDto empresaDto) {
        this.repository.save(this.mapper.toEmpresaCreacion(empresaDto));
    }

    @Transactional
    @Override
    public void eliminar(Long id) {
        Empresa empresa = this.repository.findById(id)
                .orElseThrow();
        empresa.inactivarEmpresa();
        this.repository.save(empresa);
    }

    @Override
    public EmpresaDto buscar(Long id) {
        return this.repository.findById(id)
                .map(this.mapper::toEmpresaDto)
                .orElseThrow();
    }

    @Override
    public void actualizar(EmpresaDto empresaDto) {
        Empresa empresa = this.repository.findById(empresaDto.getId())
                .orElseThrow();
        empresa.setAbreviatura(empresaDto.getAbreviatura());
        empresa.setNit(empresaDto.getNit());
        empresa.setNombre(empresaDto.getNombre());
        this.repository.save(empresa);
    }

    @Override
    public List<EmpresaDto> obtenerTodos() {
        return this.mapper.toEmpresasDto(this.repository.findAll());
    }
}
