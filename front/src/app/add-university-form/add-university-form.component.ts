import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UniversiteService } from '../services/universite.service';
import { Foyer } from '../models/foyer.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-university-form',
  templateUrl: './add-university-form.component.html',
  styleUrls: ['./add-university-form.component.css']
})
export class AddUniversityFormComponent {
  newUniversiteForm: FormGroup;
  foysers: Foyer[] = [];
  assignFoyer: boolean = true; // Set this based on your logic

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private universiteService: UniversiteService
  ) {
    this.newUniversiteForm = this.formBuilder.group({
      nomUniversite: ['', Validators.required],
      adresseUniversite: ['', Validators.required],
      foyer: [null],
    });
  }

  ngOnInit(): void {
    this.loadFoysers();
  }

  loadFoysers(): void {
    this.universiteService.getAllFoyers().subscribe(
      data => {
        this.foysers = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  addNewUniversity(): void {
    if (this.newUniversiteForm.valid) {
      const newUniversite = this.newUniversiteForm.value;
      console.log('Form value:', newUniversite);
  
      this.universiteService.addUniversity(newUniversite).subscribe(
        addedUniversity => {
          console.log('University added successfully:', addedUniversity);
          this.router.navigate(['/admin/university-table']);
        },
        error => {
          console.error('Error adding university:', error);
        }
      );
    } else {
      console.error('Error adding university: Form is invalid');
    }
  
  } 
}
