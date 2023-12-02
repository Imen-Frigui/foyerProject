import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UniversiteListComponent } from './universite-list/universite-list.component';
import { HomeComponent } from './home/home.component';
import { UniversityTableComponent } from './university-table/university-table.component';
import { EditUniversityComponent } from './edit-university/edit-university.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'universities', component: UniversiteListComponent },
  {path: 'admin',
    children: [
      { path: 'university-table', component: UniversityTableComponent },
      { path: 'edit-university/:id', component: EditUniversityComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
