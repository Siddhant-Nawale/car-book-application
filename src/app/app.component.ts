import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CabListComponent } from './cab-list/cab-list.component';
import { CommonModule } from '@angular/common';
import { CabDetailsComponent } from './cab-details/cab-details.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, CabListComponent, CabDetailsComponent],
  templateUrl: './app.component_main.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'BookIt-fe';

}
