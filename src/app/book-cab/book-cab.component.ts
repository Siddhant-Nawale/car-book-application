import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { Cab } from '../entity/Cab';
import { CabListComponent } from '../cab-list/cab-list.component';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-book-cab',
  standalone: true,
  imports: [CabListComponent, FormsModule],
  templateUrl: './book-cab.component.html',
  styleUrl: './book-cab.component.css'
})
export class BookCabComponent {
  cabList: Cab[] | null = null;

  constructor(private apiService: ApiService, private router: Router) {
  }

  showInTable: boolean = true;
  extraButtonConfig: any = [
    { name: "Book", handler: this.redirectToBook.bind(this) }
  ]

  redirectToBook(id: number) {
    this.router.navigate([`/book-cab-form/${id}`]);
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
