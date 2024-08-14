import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Role} from "../models/role.model";
import {StorageService} from "./storage.service";

const API_URL = 'http://localhost:8080/api/v1/users';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  typeCrud = '';
  users: any;
  headers = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + this.storageService.getUser().token
    })
  };

  constructor(private http: HttpClient, private storageService: StorageService) {
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', {responseType: 'text'});
  }

  create(username?: string, password?: string, roles?: Role[]): Observable<any> {
    return this.http.post(
      API_URL,
      {
        username,
        password,
        roles
      },
      this.headers
    );
  }

  get(role?: string) {
    let url = API_URL;
    if (role != undefined) {
      url = url + '?role=' + role;
    }
    this.http.get(url, this.headers).subscribe({
      next: data => {
        console.log(data);
        this.users = data;
      }
    });
  }

  update(id: string, username: string) {
    this.http.put(API_URL + '?id=' + id + '&name=' + username, this.headers).subscribe({
      next: data => {
        console.log(data);
        this.get();
      }
    });
  }

  delete(id: string) {
    this.http.delete(API_URL + '/' + id, this.headers).subscribe({
      next: data => {
        console.log(data);
        if (this.storageService.getUser().roles.at(0).role == 'ROLE_ADMIN') {
          this.get('ROLE_MANAGER');
        } else if (this.storageService.getUser().roles.at(0).role == 'ROLE_MANAGER') {
          this.get('ROLE_USER');
        }
      }
    });
  }
}
