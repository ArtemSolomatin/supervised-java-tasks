import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {routes} from '../../routes';
import {isNullOrUndefined} from 'util';

@Component({
  selector: 'app-students-add',
  templateUrl: './students-add.component.html',
  styleUrls: [ '../students.component.css' ]
})
export class StudentsAddComponent {
  constructor(
    private location: Location,
    private http: HttpClient
  ) {}

  students: any;
  studentId: string;
  facultyId: string;
  recordbookNum: string;
  fullName: string;
  groupNum: string;

  addStudent(): void {
    if (isNullOrUndefined(this.studentId) || isNullOrUndefined(this.facultyId) ||
      isNullOrUndefined(this.recordbookNum) || isNullOrUndefined(this.recordbookNum) || isNullOrUndefined(this.groupNum)) {
      alert('Какое-то поле не проставлено');
      return;
    }
    this.http.get(`${routes.gateway}/addStudent?studentId=${this.studentId}&facultyId=${this.facultyId}&recordbookNum=${this.recordbookNum}&fullName=${this.fullName}&groupNum=${this.groupNum}`)
      .subscribe(data => {
      console.log(data);
      this.students = data;
    });
    this.studentId = '';
    this.facultyId = '';
    this.recordbookNum = '';
    this.fullName = '';
    this.groupNum = '';
  }

  goBack(): void {
    this.location.back();
  }
}
