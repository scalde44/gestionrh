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
  generos = [
    { label: 'Masculino', value: 'masculino' },
    { label: 'Femenino', value: 'femenino' }
  ];
  tiposIdentificacion = [
    { label: 'Cédula', value: 'cedula' },
    { label: 'Pasaporte', value: 'pasaporte' }
  ];

  overlayState = 'start';

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      profesion: ['', Validators.required],
      nombre: ['', Validators.required],
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


  onSubmit() {
    if (this.form.valid) {
      console.log('Formulario enviado:', this.form.value);
    } else {
      console.log('Formulario inválido');
    }
  }
  // Cambiar el estado de la animación según sea necesario
  toggleAnimation() {
    this.overlayState = this.overlayState === 'start' ? 'end' : 'start';
  }
}
