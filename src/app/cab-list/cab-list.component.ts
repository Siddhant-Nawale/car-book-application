import { Component, Input } from '@angular/core';
import { ApiService } from '../api.service';
import { Cab } from '../entity/Cab';
import { CommonModule, } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CabDetailsComponent } from '../cab-details/cab-details.component';

@Component({
  selector: 'app-cab-list',
  standalone: true,
  imports: [FormsModule, CommonModule, CabDetailsComponent],
  templateUrl: './cab-list.component.html',
  styleUrl: './cab-list.component.css'
})
export class CabListComponent {
  @Input() cabList: Cab[] | null = null;
  @Input() showInTable: boolean = true;
  @Input() extraButtonConfig: any = [];

  constructor(private apiService: ApiService) {
  }

  getIfKeyCountValid(){
    return Object.keys(this.extraButtonConfig).length !== 0;
  }
}
