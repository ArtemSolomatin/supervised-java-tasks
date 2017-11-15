import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-assessments-remove',
  templateUrl: './assessments-remove.component.html',
  styleUrls: [ './assessments-add.component.css' ]
})
export class AssessmentsRemoveComponent {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  assessments: any;
  assessmentId: string;


  removeAssessment(): void {
    this.http.get(`http://localhost:8090/deleteAssessment?assessmentId=` + this.assessmentId)
      .subscribe(data => {
        console.log(data);
      this.assessments = data;
    });
    this.assessmentId = '';
  }

  goBack(): void {
    this.location.back();
  }
}
