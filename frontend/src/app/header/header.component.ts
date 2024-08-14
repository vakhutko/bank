import {Component} from '@angular/core';
import {Router, RouterLink} from "@angular/router";
import {AuthService} from "../_services/auth.service";
import {StorageService} from "../_services/storage.service";

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    RouterLink
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  isAuthorize = this.storageService.isLoggedIn();
  newClass = 'dropdown-menu text-small';
  isShowClass = false;
  dataPopperPlacement = 'bottom-start';
  showClass = 'd-block link-body-emphasis text-decoration-none dropdown-toggle show';
  showStyle = 'position: absolute; inset: 0px auto auto 0px; margin: 0px; transform: translate3d(0px, 34.4px, 0px);';

  constructor(private authService: AuthService, private storageService: StorageService, private router: Router) {
  }

  showMenu(): void {
    if (this.newClass.endsWith('show')) {
      this.newClass = 'dropdown-menu text-small';
    } else {
      this.newClass = 'dropdown-menu text-small show';
    }
  }

  logout(): void {
    this.authService.logout().subscribe({
      next: res => {
        console.log(res);
        this.storageService.clean();

        this.router.navigate(['/']).then(this.reloadPage);
      },
      error: err => {
        console.log(err);
      }
    });
  }

  reloadPage(): void {
    window.location.reload();
  }
}
