import { Universite } from "./universite.model";

export interface Foyer {
        idFoyer: number;
        nomFoyer: string;
        capacityFoyer: number;
        universite: Universite;
}