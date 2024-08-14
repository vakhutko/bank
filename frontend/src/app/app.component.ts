import {Component, OnInit} from '@angular/core';
import {RouterLink, RouterLinkActive, RouterOutlet} from '@angular/router';
import {FormsModule} from "@angular/forms";
import {NgClass} from "@angular/common";
import {HeaderComponent} from "./header/header.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {FooterComponent} from "./footer/footer.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLinkActive, RouterLink, RouterLinkActive, FormsModule, NgClass, HeaderComponent, NavbarComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  themeHref = '#moon-stars-fill';
  darkActive = 'active';
  lightActive = '';
  ariaPassed = true;
  schemaColor = 'dark';
  schemaAriaColor = 'Toggle theme (' + this.schemaColor + ')';
  schemaColorClick = false;
  // form: any = {
  //   username: null,
  //   password: null
  // };
  // username?: string;
  // roles: string[] = [];

  ngOnInit(): void {
    // this.isLoggedIn = this.storageService.isLoggedIn();
    //
    // if (this.isLoggedIn) {
    //   const user = this.storageService.getUser();
    //   this.roles = user.roles;
    //
    //   this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
    //   this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
    //
    //   this.username = user.username;
    // }
  }
}
