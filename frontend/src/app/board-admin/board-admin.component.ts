import {Component, OnInit} from '@angular/core';
import {UserService} from "../_services/user.service";
import {FormsModule} from "@angular/forms";
import {NgClass} from "@angular/common";
import {User} from "../models/user.model";
import {Role} from "../models/role.model";

@Component({
  selector: 'app-board-admin',
  standalone: true,
  imports: [
    FormsModule,
    NgClass
  ],
  templateUrl: './board-admin.component.html',
  styleUrl: './board-admin.component.css'
})
export class BoardAdminComponent implements OnInit {
  role_1: Role = {
    role: 'ROLE_MANAGER'
  };
  role_2: Role = {
    role: 'ROLE_USER'
  };
  roles?: Role[] = [this.role_1, this.role_2];
  user: User = {
    username: '',
    password: '',
    roles: this.roles
  };
  content?: string;
  errorMessage = '';
  update = 0;

  constructor(protected userService: UserService) {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    // const { username, password, roles } = this.user;

    this.userService.create(this.user.username, this.user.password, this.user.roles).subscribe({
      next: data => {
        // this.errorMessage = data;
        // this.userService.create(username, password, roles);
        // this.storageService.saveUser(data);
        //
        // this.isLoginFailed = false;
        // this.isLoggedIn = true;
        // this.roles = this.storageService.getUser().roles;
        // if (this.roles.at(0) == 'ROLE_USER') {
        //   this.router.navigate(['/user']).then(this.reloadPage);
        // } else if (this.roles.at(0) == 'ROLE_ADMIN') {
        //   this.router.navigate(['/admin']).then(this.reloadPage);
        // }
        this.reloadPage();
      },
      error: err => {
        this.errorMessage = err.error.message;
        // this.isLoginFailed = true;
      }
    });
  }

  reloadPage(): void {
    window.location.reload();
  }
}
