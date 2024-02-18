import { Component, OnInit } from '@angular/core';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../models/client.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-client-read',
  templateUrl: './client-read.component.html',
  styleUrls: ['./client-read.component.css']
})
export class ClientReadComponent implements OnInit {
  clients!: Client[];
  columnsToDisplay = ['id', 'name', 'contactNumber', 'address', 'gender', 'department', 'skills', 'isActive', 'actions'];

  constructor(private service: ClientService, private router: Router) { }

  ngOnInit(): void {
    this.service.readClient().subscribe(clients => {
      this.clients = clients;
    });
  }

  navigateToClientCreate(): void {
    this.router.navigate(["clients/create"]);
  }
}
