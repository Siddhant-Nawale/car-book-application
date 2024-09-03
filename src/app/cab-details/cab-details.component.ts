import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Cab } from '../entity/Cab';
import { CommonModule } from '@angular/common';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-cab-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cab-details.component.html',
  styleUrls: ['./cab-details.component.css']
})
export class CabDetailsComponent implements OnChanges {
  @Input() cab: Cab = {
    cabNo: -1,
    route: "",
    nextAvailableAt: -1,
    numberOfSeatsBooked: -1
  };

  @Input() cabNo: number = -1;
  @Input() extraButtonConfig: any = {};
  @Input() showInTable: boolean = false;

  constructor(private apiService: ApiService) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['cabNo'] && this.cabNo !== -1) {
      this.apiService.fetchCab(this.cabNo).subscribe({
        next: (cab: Cab) => {
          this.cab = cab;
        },
        error: (err) => {
          console.error('Error fetching cab details:', err);
          alert('Failed to fetch cab details');
        }
      });
    }
  }

  getKeys(cab: Cab): string[] {
    return Object.keys(cab);
  }

  getCabProperty(cab: Cab, key: string): any {
    if (key in cab) {
      return cab[key as keyof Cab];
    }
    return undefined;
  }
}
