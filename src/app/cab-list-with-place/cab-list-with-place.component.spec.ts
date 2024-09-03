import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CabListWithPlaceComponent } from './cab-list-with-place.component';

describe('CabListWithPlaceComponent', () => {
  let component: CabListWithPlaceComponent;
  let fixture: ComponentFixture<CabListWithPlaceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CabListWithPlaceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CabListWithPlaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
