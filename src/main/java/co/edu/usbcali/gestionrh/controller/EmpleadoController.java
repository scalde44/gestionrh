package co.edu.usbcali.gestionrh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.gestionrh.model.dto.EmpleadoDTO;
import co.edu.usbcali.gestionrh.model.dto.request.CreateEmpleadoRequest;
import co.edu.usbcali.gestionrh.service.EmpleadoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {
  private final EmpleadoService empleadoService;

  @PostMapping("/add")
  public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody CreateEmpleadoRequest createEmpleadoRequest)  throws Exception {
    EmpleadoDTO empleadoDTO = empleadoService.crear(createEmpleadoRequest);

    return ResponseEntity.ok(empleadoDTO);
  }
}
