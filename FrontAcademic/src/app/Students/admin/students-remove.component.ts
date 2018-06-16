import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {routes} from "../../routes";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-students-remove',
  templateUrl: './students-remove.component.html',
  styleUrls: [ '../students.component.css' ]
})
export class StudentsRemoveComponent {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  students: any;
  studentId: string;

  removeStudent(): void {
    if (isNullOrUndefined(this.studentId)) {
      alert('Какое-то поле не проставлено');
      return;
    }
    this.http.get(`${routes.gateway}/deleteStudent?studentId=${this.studentId}`)
      .subscribe(data => {
        console.log(data);
        this.students = data;
      });
    this.studentId = '';
  }

  goBack(): void {
    this.location.back();
  }
}
