import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookCabFormComponent } from './book-cab-form.component';

describe('BookCabFormComponent', () => {
  let component: BookCabFormComponent;
  let fixture: ComponentFixture<BookCabFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BookCabFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookCabFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
