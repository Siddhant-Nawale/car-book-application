import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { Cab } from '../entity/Cab';
import { CabDetailsComponent } from '../cab-details/cab-details.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CabListComponent } from '../cab-list/cab-list.component';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-all-cabs',
  standalone: true,
  imports: [FormsModule, CommonModule, CabListComponent],
  templateUrl: './list-all-cabs.component.html',
  styleUrl: './list-all-cabs.component.css'
})
export class ListAllCabsComponent {
  cabList: Cab[] | null = null;
  showInTable: boolean = true;
  extraButtonConfig: any = [
    { name: "Delete", handler: this.deleteCab.bind(this) },
    { name: "Update", handler: this.redirectToUpdate.bind(this) },
  ]

  constructor(private apiService: ApiService, private router: Router) {
    this.performFetch();
  }

  performFetch(){
    this.apiService.fetchAllCabs().subscribe({
      next: (cabs: Cab[]) => {
        console.log(cabs)
        this.cabList = cabs;
      }, error: (err) => {
        alert(err);
      }, complete: () => {

      },
    });
  }
  redirectToUpdate(id: number) {
    this.router.navigate([`/update-cab/${id}`]);
  }

  deleteCab(id: number) {
    this.apiService.deleteCabWithId(id).subscribe({
      next: (msg: any) => {
        this.performFetch();
      }, error: (err) => {
        alert(err?.error?.message);
      }, complete: () => {

      },
    });
  }

  toggleView(view: string) {
    this.showInTable = view === 'table';
  }
}
