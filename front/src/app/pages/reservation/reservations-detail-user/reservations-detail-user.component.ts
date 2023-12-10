import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { chamber } from 'src/app/models/chambre';
import { Reservation } from 'src/app/models/reservation';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservations-detail-user',
  templateUrl: './reservations-detail-user.component.html',
  styleUrls: ['./reservations-detail-user.component.scss']
})
export class ReservationsDetailUserComponent implements OnInit {

  idUser: number;
  idReservation: number;
  reservation: Reservation;
  chambre: chamber;
  numberErudiantForChambre: number;

  constructor(
    private reservationService: ReservationService,
    private route: ActivatedRoute,
    private router: Router,
    ) { }

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.idReservation = params['idRes'];
      this.idUser = params['idUser'];
      this.reservationService.getReservation(this.idReservation).subscribe((reservation: Reservation) => {
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


}
