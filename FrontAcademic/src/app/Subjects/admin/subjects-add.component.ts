import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-subject-add',
  templateUrl: './subjects-add.component.html',
  styleUrls: [ './subjects-add.component.css' ]
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
    this.http.get(`http://localhost:8090/addSubject?subjectId=` + this.subjectId +
      `&subjectNum=` + this.subjectNum + `&subjectName=` + this.subjectName).subscribe(data => {
      console.log(data);
      this.subjects = data;
    });
  }

  goBack(): void {
    this.location.back();
  }
}
