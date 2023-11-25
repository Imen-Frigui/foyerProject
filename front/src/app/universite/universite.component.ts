import { Component, Input } from '@angular/core';
import { Universite } from '../models/universite.model';


@Component({
  selector: 'app-universite',
  templateUrl: './universite.component.html',
  styleUrls: ['./universite.component.css']
})
export class UniversiteComponent {
  @Input() university!: Universite;

}
