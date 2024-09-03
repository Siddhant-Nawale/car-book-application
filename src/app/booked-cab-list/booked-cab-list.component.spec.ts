import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookedCabListComponent } from './booked-cab-list.component';

describe('BookedCabListComponent', () => {
  let component: BookedCabListComponent;
  let fixture: ComponentFixture<BookedCabListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BookedCabListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookedCabListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
