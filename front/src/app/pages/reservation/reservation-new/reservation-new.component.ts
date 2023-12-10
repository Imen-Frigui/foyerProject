import { Component, OnInit } from '@angular/core';
import { bloc } from 'src/app/models/bloc';
import { chamber } from 'src/app/models/chambre';
import { foyer } from 'src/app/models/foyer';
import { Reservation } from 'src/app/models/reservation';
import { universite } from 'src/app/models/universite';
import { ReservationService } from 'src/app/services/reservation.service';

@Component({
  selector: 'app-reservation-new',
  templateUrl: './reservation-new.component.html',
  styleUrls: ['./reservation-new.component.scss']
})
export class ReservationNewComponent implements OnInit {
  universites: universite[];
  selected_universite: universite = null;
  foyer: foyer= null;
  blocs: bloc[]= null;
  selected_bloc: bloc;
  chambres: chamber[]= null;
  selected_chambre: chamber;

  constructor(
    private reservationService: ReservationService,
  ) { }

  ngOnInit(): void {
    this.reservationService.getAlluniversities().subscribe((universites: universite[]) => {
      this.universites = universites;
    })
  }

  selectuni(uni: universite) {
    this.selected_universite = uni
    this.reservationService.getfoyerbyuniversite(uni.idUniversite).subscribe((foyer: foyer) => {
      this.foyer = foyer;
      this.blocs = foyer.blocList;
    })
  }

  selectbloc(bloc: bloc) {
    this.selected_bloc = bloc
    this.chambres = bloc.chamberList;
    console.log(bloc);
    console.log(this.chambres)
  }

  selectchambre(chambre: chamber) {
    this.selected_chambre = chambre
  }



}
