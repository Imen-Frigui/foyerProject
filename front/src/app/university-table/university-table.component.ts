import { Component } from '@angular/core';
import { UniversiteService } from '../services/universite.service';
import { Universite } from '../models/universite.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-university-table',
  templateUrl: './university-table.component.html',
  styleUrls: ['./university-table.component.css']
})
export class UniversityTableComponent {
  universities: Universite[] = [];

  constructor(private universiteService: UniversiteService, private router: Router) { }

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
  deleteUniversity(id: number): void {
    this.universiteService.deleteUniversity(id).subscribe(() => {
      // Reload universities after deletion
      this.loadUniversities();
    });
  }
  editUniversity(id: number): void {
    this.router.navigate(['admin/edit-university', id]);
  }

}
