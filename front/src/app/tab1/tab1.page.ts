import { Component, OnInit } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonCol, IonIcon, IonLabel, IonRow } from '@ionic/angular/standalone';
import { Empleado } from '../models/empleado';
import { EmpleadoService } from '../services/empleado.service';
import { CommonModule } from '@angular/common';
import {dateTimestampProvider} from "rxjs/internal/scheduler/dateTimestampProvider";
import { TableModule } from 'primeng/table';
import { SpeedDialModule } from 'primeng/speeddial';
import { MenuItem, MessageService,PrimeIcons } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: true,
  imports: [CommonModule, IonIcon, IonRow, IonCol, IonGrid, IonLabel, IonHeader, IonToolbar, IonTitle, IonContent,SpeedDialModule,ToastModule,TableModule],
  providers:[MessageService]
})
export class Tab1Page implements OnInit {
  items!: MenuItem[];
  empleados: Empleado[] = [];
  constructor(private empleadoService:EmpleadoService,private router: Router) {}
  ngOnInit(): void {
    this.empleadoService.todos().subscribe({
      next: (empleados: Empleado[]) => {
        this.empleados = empleados;
      },
      error: (error: any) => {
        console.log('Error', error);
      }
    });
    this.items = [
      {
        icon: 'pi pi-check',
        command: () => { this.eliminarRegistro()
        }
      },
      {
        icon: PrimeIcons.TRASH,
        command: () => {
          //this.messageService.add({ severity: 'success', summary: 'Update', detail: 'Data Updated' });
        }
      }]
  }

  cambiarTab(tab: string) {
    this.router.navigate([`/tabs/${tab}`]);
  }

  eliminarRegistro() {
    Swal.fire({
      title: '¿Estás seguro?',
      text: "¡No podrás revertir esta acción!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#3085d6',
      confirmButtonText: 'Sí, eliminarlo!',
    }).then((result) => {
      if (result.isConfirmed) {
        // Lógica para eliminar el registro
        Swal.fire(
          '¡Eliminado!',
          'El registro ha sido eliminado.',
          'success'
        );
      }
    });
  }
    protected readonly dateTimestampProvider = dateTimestampProvider;
}
