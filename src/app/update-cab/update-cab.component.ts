import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../api.service';
import { Cab } from '../entity/Cab';
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-cab',
  standalone: true,
  imports: [CommonModule, FormsModule], // Add FormsModule here
  templateUrl: './update-cab.component.html',
  styleUrls: ['./update-cab.component.css']
})
export class UpdateCabComponent implements OnInit {
  cab: Cab | null = null;
  isLoading: boolean = true;

  constructor(
    private apiService: ApiService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const cabNo = this.route.snapshot.paramMap.get('cabNo');
    if (cabNo) {
      this.apiService.fetchCab(Number(cabNo)).subscribe({
        next: (cab: Cab) => {
          this.cab = cab;
          this.isLoading = false;
        },
        error: (err) => {
          console.error('Error fetching cab details:', err);
          alert(err.error.message);
          this.router.navigate(['/']); // Redirect to home or error page
        }
      });
    }
  }

  updateCab(): void {
    if (this.cab) {
      this.apiService.updateCab(this.cab).subscribe({
        next: () => {
          alert('Cab updated successfully');
          this.router.navigate(['/']); // Redirect after update
        },
        error: (err) => {
          console.error('Error updating cab:', err);
          alert(err.error.message);

        }
      });
    }
  }
}
