import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UniversiteListComponent } from './universite-list/universite-list.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { UniversiteComponent } from './universite/universite.component';
import { UniversityTableComponent } from './university-table/university-table.component';


@NgModule({
  declarations: [
    AppComponent,
    UniversiteListComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    UniversiteComponent,
    UniversityTableComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
