import {Component, OnInit} from '@angular/core';
import {AuthService} from "../_services/auth.service";
import {StorageService} from "../_services/storage.service";
import {FormsModule} from "@angular/forms";
import {NgClass, NgOptimizedImage} from "@angular/common";
import {Router} from "@angular/router";
import {Role} from "../models/role.model";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule,
    NgClass,
    NgOptimizedImage
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: Role[] = [];

  constructor(private authService: AuthService, private storageService: StorageService, private router: Router) {
  }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getUser().roles;
    }
  }

  onSubmit(): void {
    const {username, password} = this.form;

    this.authService.login(username, password).subscribe({
      next: data => {
        this.storageService.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.storageService.getUser().roles;
        this.authService.token = data.token;
        console.log('start')
        console.log(this.authService.token);
        console.log('end')
        let role = this.roles.at(0);
        if (role != undefined) {
          if (role.role == 'ROLE_USER') {
            this.router.navigate(['/user']).then(this.reloadPage);
          } else if (role.role == 'ROLE_ADMIN') {
            this.router.navigate(['/admin']).then(this.reloadPage);
          } else if (role.role == 'ROLE_MANAGER') {
            this.router.navigate(['/manager']).then(this.reloadPage);
          }
        }
        // if (this.roles.at(0).role == 'ROLE_USER') {
        //   this.router.navigate(['/user']).then(this.reloadPage);
        // } else if (this.roles.at(0) == 'ROLE_ADMIN') {
        //   this.router.navigate(['/admin']).then(this.reloadPage);
        // } else if (this.roles.at(0) == 'ROLE_MANAGER') {
        //   this.router.navigate(['/manager']).then(this.reloadPage);
        // }
        // this.reloadPage();
      },
      error: err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    });
  }

  reloadPage(): void {
    window.location.reload();
  }
}
