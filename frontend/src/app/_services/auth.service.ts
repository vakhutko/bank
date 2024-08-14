import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {StorageService} from "./storage.service";

const AUTH_API = 'http://localhost:8080/api/v1/auth/';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    // 'Content-Type': 'application/x-www-form-urlencoded',
    // 'Access-Control-Allow-Origin': 'http://localhost:8080/api/auth/signin',
    // 'Access-Control-Allow-Credentials': 'true',
    // 'Access-Control-Allow-Methods': 'GET, POST, PATCH, PUT, DELETE, OPTIONS',
    // 'Access-Control-Allow-Headers': 'Origin, Content-Type, X-Auth-Token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  token?: string;

  constructor(private http: HttpClient, private storageService: StorageService) {
  }

  login(username: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'login',
      {
        username,
        password
      },
      httpOptions
    );
  }

  register(username: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'register',
      {
        username,
        password,
      },
      httpOptions
    );
  }

  logout(): Observable<any> {
    let headers = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + this.storageService.getUser().token
      })
    };
    return this.http.post(AUTH_API + 'logout', {}, headers);
  }
}
