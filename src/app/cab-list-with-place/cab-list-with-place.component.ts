import { Component } from '@angular/core';
import { Cab } from '../entity/Cab';
import { ApiService } from '../api.service';
import { CabListComponent } from '../cab-list/cab-list.component';

@Component({
  selector: 'app-cab-list-with-place',
  standalone: true,
  imports: [CabListComponent],
  templateUrl: './cab-list-with-place.component.html',
  styleUrl: './cab-list-with-place.component.css'
})
export class CabListWithPlaceComponent {
  cabList: Cab[] = [];
  showInTable: boolean = true;
  constructor(private apiService: ApiService) {
 
  }
  fetchData(placeName: string) {
    this.apiService.fetchCabsWithPlace(placeName).subscribe({
      next: (cabs: Cab[]) => {
        console.log(cabs)
        this.cabList = cabs;
      }, error: (err) => {
        alert(err);
      }, complete: () => {

      },
    });
  }

  toggleView(view: string) {
    this.showInTable = view === 'table';
  }
}
