import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service'; // Adjust the path as necessary
import { FormsModule } from '@angular/forms';
import { Booking } from '../entity/Booking';
import { CabDetailsComponent } from '../cab-details/cab-details.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-cab-form',
  templateUrl: './book-cab-form.component.html',
  styleUrls: ['./book-cab-form.component.css'],
  imports: [FormsModule, CabDetailsComponent, CommonModule],
  standalone: true
})
export class BookCabFormComponent implements OnInit {
  cabNo: number = -1;
  numOfSeats: number = 0;
  isLoading: boolean = false;
  EmployeeNumbers: number[] = [];

  constructor(
    private apiService: ApiService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    // Get the cab number from route parameters
    this.cabNo = Number(this.route.snapshot.paramMap.get('cabNo'));
  }

  onSeatsChange(): void {
    // Adjust the EmployeeNumbers array length based on numOfSeats
    this.EmployeeNumbers = new Array(this.numOfSeats).fill(null);
  }

  bookCab(): void {
    if (this.cabNo !== null && this.numOfSeats !== null && this.EmployeeNumbers.length === this.numOfSeats) {
      this.isLoading = true;
      this.apiService.bookCab(this.cabNo, this.numOfSeats, this.EmployeeNumbers).subscribe({
        next: (booking: Booking) => {
          alert('Cab booked successfully!');
          console.log('Booking details:', booking);
          this.router.navigate(['/']); // Redirect after booking
        },
        error: (err) => {
          console.error('Error booking cab:', err);
          alert(err?.error?.message);
        },
        complete: () => {
          this.isLoading = false;
        }
      });
    } else {
      alert('Please ensure all employee numbers are provided.');
    }
  }

  isArray(arr:any){
    return Array.isArray(arr)
  }
}
