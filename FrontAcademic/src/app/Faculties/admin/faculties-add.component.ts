import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {routes} from "../../routes";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-faculties-add',
  templateUrl: './faculties-add.component.html',
  styleUrls: [ '../faculties.component.css' ]
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

  addFaculty(): void {
    if (isNullOrUndefined(this.facultyId) || isNullOrUndefined(this.facultyNum) || isNullOrUndefined(this.facultyName)) {
      alert('Какое-то поле не проставлено');
      return;
    }
    this.http.get(`${routes.gateway}/addFaculty?facultyId=${this.facultyId}&facultyNum=${this.facultyNum}&facultyName=${this.facultyName}`).subscribe(data => {
      console.log(data);
      this.faculties = data;
    });
    this.facultyId = '';
    this.facultyNum = '';
    this.facultyName = '';
  }

  goBack(): void {
    this.location.back();
  }
}
