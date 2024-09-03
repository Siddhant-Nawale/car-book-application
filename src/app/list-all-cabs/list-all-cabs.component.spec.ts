import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllCabsComponent } from './list-all-cabs.component';

describe('ListAllCabsComponent', () => {
  let component: ListAllCabsComponent;
  let fixture: ComponentFixture<ListAllCabsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListAllCabsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListAllCabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
