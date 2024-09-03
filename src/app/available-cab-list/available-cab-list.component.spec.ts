import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailableCabListComponent } from './available-cab-list.component';

describe('AvailableCabListComponent', () => {
  let component: AvailableCabListComponent;
  let fixture: ComponentFixture<AvailableCabListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AvailableCabListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AvailableCabListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
