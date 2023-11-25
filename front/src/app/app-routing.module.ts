import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UniversiteListComponent } from './universite-list/universite-list.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'universities', component: UniversiteListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
