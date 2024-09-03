import { Component } from '@angular/core';
import { CabListComponent } from '../cab-list/cab-list.component';
import { Cab } from '../entity/Cab';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-available-cab-list',
  standalone: true,
  imports: [CabListComponent],
  templateUrl: './available-cab-list.component.html',
  styleUrl: './available-cab-list.component.css'
})
export class AvailableCabListComponent {
  cabList: Cab[] | null = null;
  showInTable: boolean = true;
  
  constructor(private apiService: ApiService) {
    if (!this.cabList) {
      apiService.fetchAvailableCabs().subscribe({
        next: (cabs: Cab[]) => {
          console.log(cabs)
          this.cabList = cabs;
        }, error: (err) => {
          alert(err);
        }, complete: () => {

        },
      });
    }
  }

  toggleView(view: string) {
    this.showInTable = view === 'table';
  }
}
