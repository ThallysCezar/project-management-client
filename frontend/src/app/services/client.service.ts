import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { Client } from '../models/client.model';

@Injectable({
    providedIn: 'root'
})
export class ClientService {

    baseURL = "http://localhost:8080/api/clients";

    constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

    showMessage(msg: string): void {
        this.snackBar.open(msg, 'X', {
            duration: 3000,
            horizontalPosition: "right",
            verticalPosition: "top"
        });
    }

    getClients(): Observable<Client[]> {
        return this.http.get<Client[]>(this.baseURL);
    }

    getClientById(id: number): Observable<Client> {
        return this.http.get<Client>(`${this.baseURL}/${id}`);
    }

    readClient(): Observable<Client[]> {
        return this.http.get<Client[]>(this.baseURL);
    }

    createClient(client: Client): Observable<Client> {
        return this.http.post<Client>(this.baseURL, client);
    }

    updateClient(id: number, client: Client): Observable<void> {
        const url = `${this.baseURL}/updateClient/${id}`;
        return this.http.put<void>(url, client);
    }

    deleteClient(id: number): Observable<void> {
        const url = `${this.baseURL}/deleteClient/${id}`;
        return this.http.delete<void>(url);
    }
    
}