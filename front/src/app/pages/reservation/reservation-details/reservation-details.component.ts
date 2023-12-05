import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { chamber } from 'src/app/models/chambre';
import { Reservation } from 'src/app/models/reservation';
import { ReservationService } from 'src/app/services/reservation.service';


@Component({
  selector: 'app-reservation-details',
  templateUrl: './reservation-details.component.html',
  styleUrls: ['./reservation-details.component.scss']
})
export class ReservationDetailsComponent implements OnInit {

  idReservation: number;
  reservation: Reservation;
  chambre: chamber;
  showModal: boolean = false; // Add this property
  numberErudiantForChambre: number;

  constructor(
    private reservationService: ReservationService,
    private route: ActivatedRoute,
    private router: Router,
    ) { }

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.idReservation = params['id'];
      this.reservationService.getReservations(this.idReservation).subscribe((reservation: Reservation) => {
        this.reservation = reservation;
        console.log(reservation)
      })
      this.reservationService.getChambre(this.idReservation).subscribe((chambre: chamber) => {
        this.chambre = chambre;
        console.log(chambre)
      })
      this.reservationService.getNumberEtudiantForChambre(this.idReservation).subscribe((num: number) => {
        this.numberErudiantForChambre = num;
        console.log(num)
      })
    })
  }

  changeState(state: string) {
    this.reservationService.updateState(this.reservation, state).subscribe((reservation: Reservation) => {
      this.reservation = reservation;
      if (state == "CONFIRMED") {
        this.numberErudiantForChambre++
      }
    })
  }

  showModalf() {
    this.showModal = true;
  }

  closeModalf() {
    this.showModal = false;
  }

  deleteItem() {
    this.reservationService.deleteReservation(this.reservation.idReservation).subscribe(
      () => {
        this.closeModalf();
        this.router.navigate(['/reservation/']);
      },
      (error) => {
      }
    );
    
  }

}

