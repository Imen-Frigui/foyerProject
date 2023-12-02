import { Component } from '@angular/core';
import { Universite } from '../models/universite.model';
import { ActivatedRoute, Router } from '@angular/router';
import { UniversiteService } from '../services/universite.service';

@Component({
  selector: 'app-edit-university',
  templateUrl: './edit-university.component.html',
  styleUrls: ['./edit-university.component.css']
})
export class EditUniversityComponent {
  universityId!: number;
  university: Universite = {
    idUniversite: 0,
    nomUniversite: '',
    adresseUniversite: '',
    foyer: {
      idFoyer: 0,
      nomFoyer: '',
      capacityFoyer: 0,
      universite: null as any  // or provide a valid initial value
    }
  };
  

  constructor(
    private route: ActivatedRoute,
    private universiteService: UniversiteService, private router:Router
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.universityId = +params['id'];
      this.universiteService.getUniversityById(this.universityId).subscribe(
        data => {
          this.university = data;
        },
        error => {
          console.log(error);
        }
      );
    });
  }

  updateUniversity(): void {
    this.universiteService.updateUniversity(this.university).subscribe(
      data => {
        // Handle success, e.g., show a success message or navigate to the university list page
        console.log('University updated successfully!');
        
        // Navigate back to the university table page
        this.router.navigate(['/admin/university-table']);
      },
      error => {
        console.log(error);
        // Handle error, e.g., show an error message
      }
    );
  }

}
