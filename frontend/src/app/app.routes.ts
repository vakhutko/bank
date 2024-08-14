import {Routes} from '@angular/router';
import {BoardAdminComponent} from "./board-admin/board-admin.component";
import {BoardUserComponent} from "./board-user/board-user.component";
import {ProfileComponent} from "./profile/profile.component";
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {HomeComponent} from "./home/home.component";
import {BoardManagerComponent} from "./board-manager/board-manager.component";

export const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'user', component: BoardUserComponent},
  {path: 'manager', component: BoardManagerComponent},
  {path: 'admin', component: BoardAdminComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'}
];
