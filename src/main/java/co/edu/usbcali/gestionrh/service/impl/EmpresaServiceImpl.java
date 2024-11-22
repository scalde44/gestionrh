package co.edu.usbcali.gestionrh.service.impl;

import co.edu.usbcali.gestionrh.mapper.EmpresaMapper;
import co.edu.usbcali.gestionrh.model.domain.Empresa;
import co.edu.usbcali.gestionrh.model.dto.EmpresaDto;
import co.edu.usbcali.gestionrh.repository.EmpresaRepository;
import co.edu.usbcali.gestionrh.service.EmpresaService;
import co.edu.usbcali.gestionrh.utils.validation.EmpresaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository repository;
    private final EmpresaMapper mapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void crear(EmpresaDto empresaDto) throws Exception {
        empresaDto.setEstado(true);
        if (this.repository.existsByNit(empresaDto.getNit())) {
            throw new Exception(String.format(EmpresaMessage.YA_EXISTE, empresaDto.getNit()));
        }
        this.repository.save(this.mapper.toEmpresaCreacion(empresaDto));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminar(Long id) throws Exception {
        EmpresaDto empresa = this.buscar(id);
        this.repository.deleteById(empresa.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public EmpresaDto buscar(Long id) throws Exception {
        return this.repository.findById(id)
                .map(this.mapper::toEmpresaDto)
                .orElseThrow(() -> new Exception(EmpresaMessage.NO_EXISTE));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void actualizar(EmpresaDto empresaDto) throws Exception {
        Empresa empresa = this.repository.findById(empresaDto.getId())
                .orElseThrow(() -> new Exception(EmpresaMessage.NO_EXISTE));
        empresa.setAbreviatura(empresaDto.getAbreviatura());
        empresa.setNit(empresaDto.getNit());
        empresa.setNombre(empresaDto.getNombre());
        empresa.setEstado(empresaDto.getEstado());
        this.repository.save(empresa);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmpresaDto> obtenerTodos() {
        return this.mapper.toEmpresasDto(this.repository.findAll());
    }
}
