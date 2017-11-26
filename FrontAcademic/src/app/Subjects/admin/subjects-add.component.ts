import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {routes} from '../../routes';
import {isNullOrUndefined, isUndefined} from "util";

@Component({
  selector: 'app-subject-add',
  templateUrl: './subjects-add.component.html',
  styleUrls: [ '../subjects.component.css' ]
})
export class SubjectsAddComponent {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  subjects: any;
  subjectId: string;
  subjectNum: string;
  subjectName: string;


  addSubject(): void {
    if (isNullOrUndefined(this.subjectId) || isNullOrUndefined(this.subjectNum) || isNullOrUndefined(this.subjectName)) {
      alert('Какое-то поле не проставлено');
      return;
    }
    this.http.get(`${routes.gateway}/addSubject?subjectId=${this.subjectId}&subjectNum=${this.subjectNum}&subjectName=${this.subjectName}`).subscribe(data => {
      console.log(data);
      this.subjects = data;
    });
    this.subjectId = '';
    this.subjectNum = '';
    this.subjectName = '';
  }

  goBack(): void {
    this.location.back();
  }
}
