package co.edu.usbcali.gestionrh.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.gestionrh.mapper.EmpleadoMapper;
import co.edu.usbcali.gestionrh.model.dto.EmpleadoDTO;
import co.edu.usbcali.gestionrh.model.dto.request.CreateEmpleadoRequest;
import co.edu.usbcali.gestionrh.model.dto.request.UpdateEmpleadoRequest;
import co.edu.usbcali.gestionrh.model.dto.response.EmpleadoResponse;
import co.edu.usbcali.gestionrh.service.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {
  private final EmpleadoService empleadoService;

  @GetMapping("/")
  public List<EmpleadoResponse> todos() {
    return empleadoService.obtenerTodos();
  }

  @PostMapping("/add")
  @Valid
  public ResponseEntity<EmpleadoResponse> crearEmpleado(@RequestBody @Valid CreateEmpleadoRequest createEmpleadoRequest)  throws Exception {
    return ResponseEntity.ok(empleadoService.crear(createEmpleadoRequest));
  }

  @GetMapping("/{id}")  
  public ResponseEntity<EmpleadoResponse> buscar(@PathVariable Long id) throws Exception {
    return ResponseEntity.ok(empleadoService.buscar(id));
  }

  @PutMapping("/inactivar/{id}")
  public ResponseEntity<EmpleadoResponse> inactivar(@PathVariable Long id) throws Exception {      
    return ResponseEntity.ok(EmpleadoMapper.dtoToResponse(empleadoService.inactivar(id)));
  }

  @PutMapping("/activar/{id}")
  public ResponseEntity<EmpleadoResponse> activar(@PathVariable Long id) throws Exception {      
    return ResponseEntity.ok(EmpleadoMapper.dtoToResponse(empleadoService.activar(id)));
  }

  @PutMapping("/actualizar/{id}")
  public ResponseEntity<EmpleadoResponse> actualizar(@PathVariable Long id, @RequestBody UpdateEmpleadoRequest updateEmpleadoRequest) throws Exception {
      EmpleadoDTO empleadoDTO = empleadoService.actualizar(id, updateEmpleadoRequest);
      
      return ResponseEntity.ok(EmpleadoMapper.dtoToResponse(empleadoDTO));
  }
}
