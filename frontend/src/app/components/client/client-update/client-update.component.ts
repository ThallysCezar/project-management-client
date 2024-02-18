import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from '../../../models/client.model';
import { ClientService } from '../../../services/client.service';

@Component({
  selector: 'app-client-update',
  templateUrl: './client-update.component.html',
  styleUrls: ['./client-update.component.css']
})
export class ClientUpdateComponent implements OnInit {
  form: FormGroup;
  id: number = 0;
  formUpdate!: FormGroup;
  client!: Client;
  
  constructor(private service: ClientService, private router: Router, private route: ActivatedRoute, private fb: FormBuilder) {
    this.form = this.fb.group({
      id: [{value: null, disabled: true}],
      name: [null, [Validators.nullValidator]],
      contactNumber: [null, [Validators.required]],
      address: [null, [Validators.required]],
      gender: [null, [Validators.required]],
      department: [null, [Validators.required]],
      skills: [null, [Validators.required]],
      isActive: [null, [Validators.required]],
    });
    this.form.controls['id'].disable();
    this.route.params.subscribe(params => this.id = params['id']);
  }
  
  ngOnInit(): void {
    this.service.getClientById(this.id).subscribe((client) => {
      this.client = client;
    });
  }

  updateClient(): void {
    this.service.updateClient(this.client.id, this.client).subscribe(() => {
      this.service.showMessage("Cliente alterado com sucesso!");
      this.router.navigate(["/clients"]);
    });
}

  cancel(): void {
    this.router.navigate(["/clients"]);
  }
}
