import { Component, OnInit } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonGrid, IonCol, IonIcon, IonLabel, IonRow } from '@ionic/angular/standalone';
import { ExploreContainerComponent } from '../explore-container/explore-container.component';
import { Empleado } from '../models/empleado';
import { EmpleadoService } from '../services/empleado.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss'],
  standalone: true,
  imports: [CommonModule, IonIcon, IonRow, IonCol, IonGrid, IonLabel, IonHeader, IonToolbar, IonTitle, IonContent],
})
export class Tab1Page implements OnInit {

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
  }
}
