import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/app/models/reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.scss']
})
export class ReservationsComponent implements OnInit {

  reservations: Reservation[];
  displayedReservations: Reservation[];
  rejected: number=0;
  confirmed: number=0;
  awaiting: number=0;

  constructor(private reservationService: ReservationService) { }

  ngOnInit(): void {

    this.reservationService.getAllReservations().subscribe((reservations: Reservation[]) => {
      this.reservations = reservations;
      this.displayedReservations = reservations;
      
      for (const reservation of reservations) {
        if (reservation.state=="AWAITING")
          this.awaiting++
        if (reservation.state=="REJECTED")
          this.rejected++
        if (reservation.state=="CONFIRMED")
          this.confirmed++
      }
      console.log(reservations)
    })
  }

  sort(state: string) {
    this.displayedReservations = state === "all" ? this.reservations : this.reservations.filter(reservation => reservation.state === state);
  }

}
