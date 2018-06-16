import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {routes} from "../../routes";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-assessments-add',
  templateUrl: './assessments-add.component.html',
  styleUrls: [ '../assessments.component.css' ]
})
export class AssessmentsAddComponent {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  assessments: any;
  assessmentId: string;
  studentId: string;
  subjectId: string;
  semesterNum: string;
  mark: string;
  examinerSurname: string;


  addAssessment(): void {
    if (isNullOrUndefined(this.assessmentId) || isNullOrUndefined(this.studentId) || isNullOrUndefined(this.subjectId) ||
    isNullOrUndefined(this.semesterNum) || isNullOrUndefined(this.mark) || isNullOrUndefined(this.examinerSurname)) {
      alert('Какое-то поле не проставлено');
      return;
    }
    this.http.get(`${routes.gateway}/addAssessment?assessmentId=${this.assessmentId}&studentId=${this.studentId}&subjectId=${this.subjectId}&semesterNum=${this.semesterNum}&mark=${this.mark}&examinerSurname=${this.examinerSurname}`).subscribe(data => {
      console.log(data);
      this.assessments = data;
    });
    this.assessmentId = '';
    this.studentId = '';
    this.subjectId = '';
    this.semesterNum = '';
    this.mark = '';
    this.examinerSurname = '';
  }

  goBack(): void {
    this.location.back();
  }
}
