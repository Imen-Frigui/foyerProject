import { Etudiant } from "./etudiant";

export interface Reservation {

    idReservation: number,
    state: string,
    anneUniversitaire: string,
    etudiantList: Etudiant[]
}
