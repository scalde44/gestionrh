import { Component, OnInit } from '@angular/core';
import {
  IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonCol, IonIcon, IonLabel, IonRow, IonInput,
  IonItem
} from '@ionic/angular/standalone';
import { Empleado } from '../models/empleado';
import { EmpleadoService } from '../services/empleado.service';
import { CommonModule } from '@angular/common';
import {dateTimestampProvider} from "rxjs/internal/scheduler/dateTimestampProvider";
import { TableModule } from 'primeng/table';
import { SpeedDialModule } from 'primeng/speeddial';
import { MenuItem, MessageService,PrimeIcons } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import Swal from 'sweetalert2';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: true,
  imports: [
    CommonModule, IonIcon, IonRow, IonCol, IonGrid, IonLabel, IonHeader, IonToolbar, IonTitle,
    IonContent,SpeedDialModule,ToastModule,TableModule, IonInput, IonItem, FormsModule,
    ReactiveFormsModule
  ],
  providers:[MessageService]
})
export class Tab1Page implements OnInit {
  items!: MenuItem[];
  empleados: Empleado[] = [];
  constructor(private empleadoService:EmpleadoService) {}
  ngOnInit(): void {
    this.empleadoService.todos().subscribe({
      next: (empleados: Empleado[]) => {
        this.empleados = empleados;
      },
      error: (error: any) => {
        console.log('Error', error);
      }
    });
    /*this.items = [
      {
        icon: 'pi pi-check',
        command: () => { this.inactivarRegistro()
        }
      },
      {
        icon: PrimeIcons.TRASH,
        command: () => {
          //this.messageService.add({ severity: 'success', summary: 'Update', detail: 'Data Updated' });
        }
      }]*/
  }

  /*cambiarTab(tab: string) {
    this.router.navigate([`/tabs/${tab}`]);
  }*/

  inactivarRegistro(id: number) {
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Se inactivará el registro",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, inactivarlo!',
    }).then((result) => {
      if (result.isConfirmed) {
        this.empleadoService.inactivar(id).subscribe({
          next: (empleado: Empleado) => {
            this.empleados = this.empleados.map(obj =>
              obj.id === empleado.id ? { ...obj, estado: empleado.estado } : obj
            );

            Swal.update({
              title: '¡Listo!',
              text: "El registro ha quedado inactivo.",
              icon: 'success',
            })
          },
          error: (error: any) => {
            console.log('Error', error);
            Swal.update({
              title: '¡Error!',
              text: "Ocurrió un error",
              icon: 'error',
            })
          }
        });
      }
    });
  }

  activarRegistro(id: number) {
    Swal.fire({
      title: '¿Estás seguro?',
      text: "Se activará el registro",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, activarlo!',
    }).then((result) => {
      if (result.isConfirmed) {
        this.empleadoService.activar(id).subscribe({
          next: (empleado: Empleado) => {
            this.empleados = this.empleados.map(obj =>
              obj.id === empleado.id ? { ...obj, estado: empleado.estado } : obj
            );

            Swal.update({
              title: '¡Listo!',
              text: "El registro ha quedado activo.",
              icon: 'success',
            })
          },
          error: (response: any) => {
            console.log('Error', response.error);
            Swal.update({
              title: '¡Error!',
              text: response.error.detail,
              icon: 'error',
            })
          }
        });
      }
    });
  }
    protected readonly dateTimestampProvider = dateTimestampProvider;
}
