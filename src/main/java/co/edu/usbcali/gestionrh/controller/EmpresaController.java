package co.edu.usbcali.gestionrh.controller;

import co.edu.usbcali.gestionrh.model.dto.EmpresaDto;
import co.edu.usbcali.gestionrh.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/empresa")
public class EmpresaController {
    private final EmpresaService service;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<EmpresaDto> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public EmpresaDto buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(EmpresaDto empresaDto) {
        this.service.crear(empresaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        this.service.eliminar(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void actualizar(@PathVariable Long id, EmpresaDto empresaDto) {
        this.service.actualizar(empresaDto);
    }
}
