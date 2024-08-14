import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import {NgClass} from "@angular/common";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    FormsModule,
    RouterOutlet,
    NgClass
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  role = '';

  ngOnInit(): void {
  }
}
