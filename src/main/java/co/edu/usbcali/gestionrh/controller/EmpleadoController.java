package co.edu.usbcali.gestionrh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.gestionrh.model.dto.request.CreateEmpleadoRequest;
import co.edu.usbcali.gestionrh.model.dto.response.EmpleadoResponse;
import co.edu.usbcali.gestionrh.service.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {
  private final EmpleadoService empleadoService;

  @PostMapping("/add")
  @Valid
  public ResponseEntity<EmpleadoResponse> crearEmpleado(@RequestBody @Valid CreateEmpleadoRequest createEmpleadoRequest)  throws Exception {
    EmpleadoResponse empleadoResponse = empleadoService.crear(createEmpleadoRequest);

    return ResponseEntity.ok(empleadoResponse);
  }

  @GetMapping("/api/v1/empleado/{id}")  
  public ResponseEntity<EmpleadoResponse> buscar(@PathVariable Long id) throws Exception {

    EmpleadoResponse empleadoResponse = empleadoService.buscar(id);

    return ResponseEntity.ok(empleadoResponse);
  }
}
