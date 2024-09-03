import { Component, Input } from '@angular/core';
import { CabListComponent } from '../cab-list/cab-list.component';
import { ApiService } from '../api.service';
import { Cab } from '../entity/Cab';

@Component({
  selector: 'app-booked-cab-list',
  standalone: true,
  imports: [CabListComponent],
  templateUrl: './booked-cab-list.component.html',
  styleUrl: './booked-cab-list.component.css'
})
export class BookedCabListComponent {

  cabList: Cab[] | null = null;
  showInTable: boolean = true;
  constructor(private apiService: ApiService) {
    if (!this.cabList) {
      apiService.fetchBookedCabs().subscribe({
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
