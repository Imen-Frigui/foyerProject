import { Component, NgModule } from '@angular/core';
import { UniversiteService } from '../services/universite.service';
import { Universite } from '../models/universite.model';
import { UniversiteComponent } from '../universite/universite.component';
import { NgModel } from '@angular/forms';

@Component({
  selector: 'app-universite-list',
  templateUrl: './universite-list.component.html',
  styleUrls: ['./universite-list.component.css']
})
export class UniversiteListComponent {
  universities: Universite[] =[];

  constructor(private universiteService: UniversiteService){}

  ngOnInit(): void {
    this.loadAllUniversities();
  }

  private loadAllUniversities(): void {
    this.universiteService.getAllUniversities().subscribe(
      (universities: Universite[]) => {
        this.universities = universities;
      },
      (error) => {
        console.error('Error fetching universities:', error);
      }
    );
  }

}
