import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {RoutingModule} from './routing.module';
import {StudentsComponent} from './Students/students.component';
import {StartPageComponent} from './StartPage/start-page.component';
import {AssessmentsComponent} from './Assessments/assessments.component';
import {FacultiesComponent} from './Faculties/faculties.component';
import {SubjectsComponent} from './Subjects/subjects.component';
import {HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';


@NgModule({
  declarations: [
    AppComponent,
    AssessmentsComponent,
    FacultiesComponent,
    StudentsComponent,
    SubjectsComponent,
    StartPageComponent,
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    HttpClientModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
