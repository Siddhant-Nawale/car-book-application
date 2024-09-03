import { Routes } from '@angular/router';
import { CabListComponent } from './cab-list/cab-list.component';
import { BookedCabListComponent } from './booked-cab-list/booked-cab-list.component';
import { AvailableCabListComponent } from './available-cab-list/available-cab-list.component';
import { CabListWithPlaceComponent } from './cab-list-with-place/cab-list-with-place.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { BookCabComponent } from './book-cab/book-cab.component';
import { ListAllCabsComponent } from './list-all-cabs/list-all-cabs.component';
import { UpdateCabComponent } from './update-cab/update-cab.component';
import { BookCabFormComponent } from './book-cab-form/book-cab-form.component';
import { AddCabComponent } from './add-cab/add-cab.component';

export const routes: Routes = [
    { path: '', component: LandingPageComponent},
    { path: 'booked-cab-list', component: BookedCabListComponent},
    { path: 'available-cab-list', component: AvailableCabListComponent},
    { path: 'cab-list-with-place', component: CabListWithPlaceComponent},
    { path: 'cab-list', component: ListAllCabsComponent},
    { path: 'book-cab', component: BookCabComponent},
    { path: 'update-cab/:cabNo', component: UpdateCabComponent },
    { path: 'book-cab-form/:cabNo', component: BookCabFormComponent },
    { path: 'add-cab', component: AddCabComponent },
];
