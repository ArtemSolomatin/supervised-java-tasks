import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {routes} from "../../routes";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-assessments-remove',
  templateUrl: './assessments-remove.component.html',
  styleUrls: [ '../assessments.component.css' ]
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
    if (isNullOrUndefined(this.assessmentId)) {
      alert('Какое-то поле не проставлено');
      return;
    }
    this.http.get(`${routes.gateway}/deleteAssessment?assessmentId=${this.assessmentId}`)
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
