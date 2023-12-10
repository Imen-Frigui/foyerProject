import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReservationRoutingModule } from './reservation-routing.module';
import { ReservationsComponent } from './reservations/reservations.component';
import { ReservationDetailsComponent } from './reservation-details/reservation-details.component';
import { ReservationNewComponent } from './reservation-new/reservation-new.component';
import { ReservationsUserComponent } from './reservations-user/reservations-user.component';
import { ReservationsDetailUserComponent } from './reservations-detail-user/reservations-detail-user.component';

@NgModule({
  declarations: [
    ReservationsComponent,
    ReservationDetailsComponent,
    ReservationNewComponent,
    ReservationsUserComponent,
    ReservationsDetailUserComponent,
  ],
  imports: [
    CommonModule,
    ReservationRoutingModule,
  ]
})
export class ReservationModule { }
