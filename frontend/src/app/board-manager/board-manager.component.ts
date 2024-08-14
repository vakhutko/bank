import {Component, OnInit} from '@angular/core';
import {UserService} from "../_services/user.service";
import {FormsModule} from "@angular/forms";
import {NgClass} from "@angular/common";
import {User} from "../models/user.model";
import {Role} from "../models/role.model";

@Component({
  selector: 'app-board-manager',
  standalone: true,
  imports: [
    FormsModule,
    NgClass
  ],
  templateUrl: './board-manager.component.html',
  styleUrl: './board-manager.component.css'
})
export class BoardManagerComponent implements OnInit {
  role_1: Role = {
    role: 'ROLE_USER'
  };
  roles?: Role[] = [this.role_1];
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
    const {username, password, roles} = this.user;
    this.userService.create(username, password, roles).subscribe({
      next: data => {
        this.errorMessage = data;
        this.reloadPage();
      },
      error: err => {
        this.errorMessage = err.error.message;
      }
    });
  }

  reloadPage(): void {
    window.location.reload();
  }
}
