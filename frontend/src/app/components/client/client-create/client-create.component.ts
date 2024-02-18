import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../../../models/client.model';
import { ClientService } from '../../../services/client.service';
import { MatDialog } from '@angular/material/dialog';
import { ErrorDialogComponent } from '../../../shared/components/error-dialog/error-dialog.component';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-client-create',
  templateUrl: './client-create.component.html',
  styleUrls: ['./client-create.component.css']
})
export class ClientCreateComponent {

  client: Client = {
    id: 0,
    name: "",
    contactNumber: "",
    address: "",
    gender: "",
    department: "",
    skills: "",
    isActive: true
  }

  constructor(private service: ClientService, private router: Router, public dialog: MatDialog) { }

  createClient(): void {
    if (this.isFormInvalid()) {
      this.onError('Por favor, preencha todas as informações antes de salvar.');
      return;
    }
    this.service.createClient(this.client).subscribe(() => {
      this.service.showMessage("Cliente criado com sucesso!");
        this.router.navigate(['/clients']);
    });
  }

  cancel(): void {
    this.router.navigate(["/clients"]);
  }

  validFields: { [key: string]: boolean } = {};

  validateField(fieldName: string, value: any) {
    this.validFields[fieldName] = !!value; // Use !! to convert to boolean
  }

  showError(fieldName: string): boolean {
    return this.validFields[fieldName] === false;
  }

  isFormInvalid(): boolean {
    return !this.client.name ||
      !this.client.contactNumber ||
      !this.client.address ||
      !this.client.gender ||
      !this.client.department ||
      !this.client.skills;
  }

  onError(message: string) {
    this.dialog.open(ErrorDialogComponent, {
      width: '250px',
      data: { message: message }
    });
  }
}