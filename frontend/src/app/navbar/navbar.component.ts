import {Component} from '@angular/core';
import {StorageService} from "../_services/storage.service";
import {UserService} from "../_services/user.service";

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  newClass = 'dropdown-menu';

  constructor(protected storageService: StorageService, protected userService: UserService) {
  }

  showMenu(): void {
    if (this.newClass.endsWith('show')) {
      this.newClass = 'dropdown-menu text-small';
    } else {
      this.newClass = 'dropdown-menu text-small show';
    }
  }
}
