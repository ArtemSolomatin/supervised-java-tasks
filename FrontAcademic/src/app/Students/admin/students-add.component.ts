import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-students-add',
  templateUrl: './students-add.component.html',
  styleUrls: [ './students-add.component.css' ]
})
export class StudentsAddComponent {
  constructor(
    private route: ActivatedRoute,
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
    this.http.get(`http://localhost:8090/addStudent?studentId=` + this.studentId +
      `&facultyId=` + this.facultyId + `&recordbookNum=` + this.recordbookNum + `&fullName=` +
      this.fullName + `&groupNum=` + this.groupNum).subscribe(data => {
      console.log(data);
      this.students = data;
    });
  }

  goBack(): void {
    this.location.back();
  }
}
