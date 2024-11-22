package co.edu.usbcali.gestionrh.service.impl;

import co.edu.usbcali.gestionrh.mapper.ProfesionMapper;
import co.edu.usbcali.gestionrh.model.domain.Profesion;
import co.edu.usbcali.gestionrh.model.dto.ProfesionDTO;
import co.edu.usbcali.gestionrh.repository.ProfesionRepository;
import co.edu.usbcali.gestionrh.service.ProfesionService;
import co.edu.usbcali.gestionrh.utils.validation.ProfesionMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfesionServiceImpl implements ProfesionService {
    private final ProfesionRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void crear(ProfesionDTO profesionDTO) throws Exception {
        profesionDTO.setNombre(profesionDTO.getNombre().toUpperCase());
        if (this.repository.existsByNombre(profesionDTO.getNombre())) {
            throw new Exception(String.format(ProfesionMessage.YA_EXISTE, profesionDTO.getNombre()));
        }
        this.repository.save(ProfesionMapper.toDomain(profesionDTO));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminar(Long id) throws Exception {
        ProfesionDTO profesion = this.buscar(id);
        this.repository.deleteById(profesion.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public ProfesionDTO buscar(Long id) throws Exception {
        return this.repository.findById(id)
                .map(ProfesionMapper::toDTO)
                .orElseThrow(() -> new Exception(ProfesionMessage.NO_EXISTE));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void actualizar(ProfesionDTO profesionDTO) throws Exception {
        Profesion profesion = this.repository.findById(profesionDTO.getId())
                .orElseThrow(() -> new Exception(ProfesionMessage.NO_EXISTE));
        profesion.setNombre(profesionDTO.getNombre());
        this.repository.save(profesion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProfesionDTO> obtenerTodos() {
        return ProfesionMapper.toDTOList(this.repository.findAll());
    }
}
