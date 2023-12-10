import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationsDetailUserComponent } from './reservations-detail-user.component';

describe('ReservationsDetailUserComponent', () => {
  let component: ReservationsDetailUserComponent;
  let fixture: ComponentFixture<ReservationsDetailUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReservationsDetailUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReservationsDetailUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
