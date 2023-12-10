import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReservationsComponent } from './reservations/reservations.component';
import { ReservationDetailsComponent } from './reservation-details/reservation-details.component';
import { ReservationNewComponent } from './reservation-new/reservation-new.component';
import { ReservationsUserComponent } from './reservations-user/reservations-user.component';
import { ReservationsDetailUserComponent } from './reservations-detail-user/reservations-detail-user.component';

const routes: Routes = [
  {
    path: "",
    component: ReservationsComponent
  },
  {
    path: "new",
    component: ReservationNewComponent
  },
  {
    path: ":idRes",
    component: ReservationDetailsComponent
  },
  {
    path: "user/:idUser",
    component: ReservationsUserComponent
  },
  {
    path: "user/:idUser/:idRes",
    component: ReservationsDetailUserComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ReservationRoutingModule { }
