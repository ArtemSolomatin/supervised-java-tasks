import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';

// TODO убрать все одинаоквые css и сделать ссылку на один
@Component({
  selector: 'app-faculties-add',
  templateUrl: './faculties-add.component.html',
  styleUrls: [ './faculties-add.component.css' ]
})
export class FacultiesAddComponent {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  faculties: any;
  facultyId: string;
  facultyNum: string;
  facultyName: string;

  add(): void {
    this.http.get(`http://localhost:8090/addFaculty?facultyId=` + this.facultyId +
      `&facultyNum=` + this.facultyNum + `&facultyName=` + this.facultyName).subscribe(data => {
      console.log(data);
      this.faculties = data;
    });
  }

  goBack(): void {
    this.location.back();
  }
}
