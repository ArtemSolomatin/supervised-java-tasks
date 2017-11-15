import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-students-remove',
  templateUrl: './students-remove.component.html',
  styleUrls: [ './students-add.component.css' ]
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
    this.http.get(`http://localhost:8090/deleteStudent?studentId=` + this.studentId)
      .subscribe(data => {
        console.log(data);
        this.students = data;
      });
  }

  goBack(): void {
    this.location.back();
  }
}
