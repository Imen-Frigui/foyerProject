import { Foyer } from "./foyer.model";

export interface Universite {
    idUniversite: number;
    nomUniversite: string;
    adresseUniversite: string;
    foyer: Foyer; 
} 