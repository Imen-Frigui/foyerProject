import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReservationRoutingModule } from './reservation-routing.module';
import { ReservationsComponent } from './reservations/reservations.component';
import { ReservationDetailsComponent } from './reservation-details/reservation-details.component';
import { ReservationNewComponent } from './reservation-new/reservation-new.component';

@NgModule({
  declarations: [
    ReservationsComponent,
    ReservationDetailsComponent,
    ReservationNewComponent,
  ],
  imports: [
    CommonModule,
    ReservationRoutingModule,
  ]
})
export class ReservationModule { }
