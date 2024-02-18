import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from '../../../models/client.model';
import { ClientService } from '../../../services/client.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-client-delete',
  templateUrl: './client-delete.component.html',
  styleUrls: ['./client-delete.component.css']
})
export class ClientDeleteComponent implements OnInit {
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
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.service.getClientById(id).subscribe((client) => {
      this.client = client;
    });
  }

  deleteclient(): void {
    this.service.deleteClient(this.client.id).subscribe(() => {
      this.service.showMessage("Excluído cliente com sucesso!");
      this.router.navigate(["/clients"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/clients"]);
  }
}
