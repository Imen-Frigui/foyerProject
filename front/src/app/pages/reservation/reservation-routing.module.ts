import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReservationsComponent } from './reservations/reservations.component';
import { ReservationDetailsComponent } from './reservation-details/reservation-details.component';
import { ReservationNewComponent } from './reservation-new/reservation-new.component';

const routes: Routes = [
  {
    path: "",
    component: ReservationsComponent
  },
  {
    path: "new/:id",
    component: ReservationNewComponent
  },
  {
    path: ":id",
    component: ReservationDetailsComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReservationRoutingModule { }
