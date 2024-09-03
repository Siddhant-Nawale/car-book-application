import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-cab',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './add-cab.component.html',
  styleUrls: ['./add-cab.component.css']
})
export class AddCabComponent {
  addCabForm: FormGroup;
  isLoading = false;

  constructor(private apiService: ApiService, private router: Router, private fb: FormBuilder) {
    this.addCabForm = this.fb.group({
      route: ['', [Validators.required]],
      nextAvailableAt: ['', [Validators.required]],
      numberOfSeatsBooked: ['', [Validators.required, Validators.min(0)]]
    });
  }

  addCab() {
    if (this.addCabForm.invalid) {
      return;
    }

    this.isLoading = true;
    const cabData = this.addCabForm.value;

    this.apiService.addCab(cabData).subscribe({
      next: (response) => {
        console.log('Cab added successfully:', response);
        this.router.navigate(['/cab-list']);
      },
      error: (err) => {
        console.error('Error adding cab:', err);
        alert(err.error.message);
      },
      complete: () => {
        this.isLoading = false;
      }
    });
  }
}
