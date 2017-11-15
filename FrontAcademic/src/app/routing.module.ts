import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {StudentsComponent} from './Students/students.component';
import {StartPageComponent} from './StartPage/start-page.component';
import {AssessmentsComponent} from './Assessments/assessments.component';
import {FacultiesComponent} from './Faculties/faculties.component';
import {SubjectsComponent} from './Subjects/subjects.component';
import {FacultiesAddComponent} from './Faculties/admin/faculties-add.component';
import {AssessmentsAddComponent} from './Assessments/admin/assessments-add.component';
import {StudentsAddComponent} from './Students/admin/students-add.component';
import {SubjectsAddComponent} from './Subjects/admin/subjects-add.component';
import {AssessmentsRemoveComponent} from './Assessments/admin/assessments-remove.component';
import {FacultiesRemoveComponent} from './Faculties/admin/faculties-remove.component';
import {StudentsRemoveComponent} from './Students/admin/students-remove.component';
import {SubjectsRemoveComponent} from './Subjects/admin/subjects-remove.component';

const routes: Routes = [
  { path: '', redirectTo: '/welcome', pathMatch: 'full' },
  { path: 'welcome',  component: StartPageComponent },
  { path: 'assessments', component: AssessmentsComponent },
  { path: 'faculties', component: FacultiesComponent },
  { path: 'students', component: StudentsComponent },
  { path: 'subjects', component: SubjectsComponent },
  { path: 'admin/addAssessment', component: AssessmentsAddComponent},
  { path: 'admin/removeAssessment', component: AssessmentsRemoveComponent},
  { path: 'admin/addFaculty', component: FacultiesAddComponent},
  { path: 'admin/removeFaculty', component: FacultiesRemoveComponent},
  { path: 'admin/addStudent', component: StudentsAddComponent},
  { path: 'admin/removeStudent', component: StudentsRemoveComponent},
  { path: 'admin/addSubject', component: SubjectsAddComponent},
  { path: 'admin/removeSubject', component: SubjectsRemoveComponent},
  ];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class RoutingModule {}
