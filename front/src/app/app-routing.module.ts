import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UniversiteListComponent } from './universite-list/universite-list.component';
import { HomeComponent } from './home/home.component';
import { UniversityTableComponent } from './university-table/university-table.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'universities', component: UniversiteListComponent },
  {path: 'admin',
    children: [
      { path: 'university-table', component: UniversityTableComponent }
      // Add more child routes as needed
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
