import { Component } from '@angular/core';
import { UniversiteService } from '../services/universite.service';
import { Universite } from '../models/universite.model';

@Component({
  selector: 'app-university-table',
  templateUrl: './university-table.component.html',
  styleUrls: ['./university-table.component.css']
})
export class UniversityTableComponent {
  universities: Universite[] = [];

  constructor(private universiteService: UniversiteService) { }

  ngOnInit(): void {
    this.loadUniversities();
  }

  loadUniversities(): void {
    this.universiteService.getAllUniversities().subscribe(
      data => {
        this.universities = data;
      },
      error => {
        console.log(error);
      }
    );
  }

}
