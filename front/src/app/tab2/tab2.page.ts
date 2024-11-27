import { Component } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { PasswordModule } from 'primeng/password';
import { MessagesModule } from 'primeng/messages';
import {IonicModule} from "@ionic/angular";
import { CardModule } from 'primeng/card';
import { CalendarModule } from 'primeng/calendar';
import { DropdownModule } from 'primeng/dropdown';
import { MessageModule } from 'primeng/message';
import { CommonModule } from '@angular/common';
import { overlayContentAnimation } from '../animaciones';
import { Empleado } from '../models/empleado';
import { EmpleadoService } from '../services/empleado.service';
import Swal from 'sweetalert2';
import { Profesion } from '../models/profesion';
import { ProfesionService } from '../services/profesion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tab2',
  templateUrl: 'tab2.page.html',
  styleUrls: ['tab2.page.scss'],
  standalone: true,
  imports: [InputTextModule, ButtonModule, PasswordModule, MessagesModule, MessageModule, IonicModule, ReactiveFormsModule,CardModule,
    CalendarModule,DropdownModule,CommonModule],
  animations: [overlayContentAnimation]
})
export class Tab2Page {
  form: FormGroup;
  empleado?: Empleado = undefined;
  profesiones: Profesion[] = [];
  generos = [
    { label: 'Masculino', value: 'm' },
    { label: 'Femenino', value: 'f' }
  ];
  tiposIdentificacion = [
    { label: 'Cédula', value: 'cedula' },
    { label: 'Pasaporte', value: 'pasaporte' }
  ];

  overlayState = 'start';

  constructor(
    private empleadoService: EmpleadoService, private profesionService: ProfesionService,
    private fb: FormBuilder, private router: Router
  ) {
    this.form = this.fb.group({
      id_profesion: ['', Validators.required],
      nombres: ['', Validators.required],
      apellidos: ['', Validators.required],
      correo: ['', [Validators.required, Validators.email]],
      direccion: ['', Validators.required],
      fechaIngreso: ['', Validators.required],
      fechaNacimiento: ['', Validators.required],
      genero: ['', Validators.required],
      tipoIdentificacion: ['', Validators.required],
      numeroIdentificacion: ['', Validators.required],
      telefono: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.profesionService.todas().subscribe({
      next: (profesiones: Profesion[]) => {
        this.profesiones = profesiones;
      },
      error: (error: any) => {
        console.log('Error', error);
      }
    });
  }

  onSubmit() {
    if (this.form.valid) {
      let empleado: Empleado = {
        id_profesion: this.form.value.id_profesion,
        nombres: this.form.value.nombres,
        apellidos: this.form.value.apellidos,
        correo: this.form.value.correo,
        direccion: this.form.value.direccion,
        estado: this.form.value.estado,
        fecha_ingreso: this.form.value.fechaIngreso,
        fecha_nacimiento: this.form.value.fechaNacimiento,
        genero: this.form.value.genero,
        tipo_identificacion: this.form.value.tipoIdentificacion,
        numero_identificacion: this.form.value.numeroIdentificacion,
        telefono: this.form.value.telefono
      }

      this.empleadoService.agregar(empleado).subscribe({
        next: (_empleado: Empleado) => {
          Swal.fire(
          {
            title: '¡Listo!',
            text: "Empleado registrado",
            icon: 'success',
            confirmButtonColor: '#4BB543',
            confirmButtonText: 'Ver listado',
            showCancelButton: true,
            cancelButtonColor: '#3085d6',
            cancelButtonText: 'Agregar otro',
          }).then((result) => {
            if (result.isConfirmed) {
              this.router.navigate(['/tabs/tab1']);
            } else {
              this.form.reset();
            }
          })
        },
        error: (response: any) => {
          console.log('Error', response.error);
          Swal.fire('¡Error!', response.error.detail, 'error');
        }
      });

      console.log('Formulario enviado:', empleado);
    } else {
      console.log('Formulario inválido');
    }
  }
  // Cambiar el estado de la animación según sea necesario
  toggleAnimation() {
    this.overlayState = this.overlayState === 'start' ? 'end' : 'start';
  }
}
