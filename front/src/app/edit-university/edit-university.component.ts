import { Component } from '@angular/core';
import { Universite } from '../models/universite.model';
import { ActivatedRoute, Router } from '@angular/router';
import { UniversiteService } from '../services/universite.service';
import { Foyer } from '../models/foyer.model';

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
      universite: null as any  
    }
  };
  foysers: Foyer[] = [];
  

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
    this.universiteService.getAllFoyers().subscribe(
      data => {
        this.foysers = data;
      },
      error => {
        console.log(error);
      }
    );
  }





  updateUniversity(): void {
    this.universiteService.updateUniversity(this.university).subscribe(
      data => {
        console.log('University updated successfully!');
        this.router.navigate(['/admin/university-table']);
      },
      error => {
        console.log(error);
      }
    );
  }

}
