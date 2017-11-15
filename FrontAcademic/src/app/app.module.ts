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
import {FacultiesAddComponent} from './Faculties/admin/faculties-add.component';
import {FormsModule} from '@angular/forms';
import {AssessmentsAddComponent} from './Assessments/admin/assessments-add.component';
import {StudentsAddComponent} from './Students/admin/students-add.component';
import {SubjectsAddComponent} from './Subjects/admin/subjects-add.component';
import {AssessmentsRemoveComponent} from './Assessments/admin/assessments-remove.component';
import {FacultiesRemoveComponent} from './Faculties/admin/faculties-remove.component';
import {StudentsRemoveComponent} from './Students/admin/students-remove.component';
import {SubjectsRemoveComponent} from './Subjects/admin/subjects-remove.component';


@NgModule({
  declarations: [
    AppComponent,
    AssessmentsComponent,
    AssessmentsAddComponent,
    AssessmentsRemoveComponent,
    FacultiesComponent,
    FacultiesAddComponent,
    FacultiesRemoveComponent,
    StudentsComponent,
    StudentsAddComponent,
    StudentsRemoveComponent,
    SubjectsComponent,
    SubjectsAddComponent,
    SubjectsRemoveComponent,
    StartPageComponent,
  ],
  imports: [
    BrowserModule,
    RoutingModule,
    HttpClientModule,
    HttpModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
