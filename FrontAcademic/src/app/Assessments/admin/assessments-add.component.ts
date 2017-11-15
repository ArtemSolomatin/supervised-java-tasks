import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-assessments-add',
  templateUrl: './assessments-add.component.html',
  styleUrls: [ './assessments-add.component.css' ]
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
    this.http.get(`http://localhost:8090/addAssessment?assessmentId=` + this.assessmentId +
      `&studentId=` + this.studentId + `&subjectId=` + this.subjectId + `&semesterNum=` + this.semesterNum +
    `&mark=` + this.mark + `&examinerSurname=` + this.examinerSurname).subscribe(data => {
      console.log(data);
      this.assessments = data;
    });
  }

  goBack(): void {
    this.location.back();
  }
}
