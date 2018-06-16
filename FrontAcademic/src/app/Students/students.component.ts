import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import {routes} from "../routes";

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: [ './students.component.css' ]
})
export class StudentsComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  students: any;

  ngOnInit(): void {
    console.log('Init');
    this.http.get(`${routes.gateway}/getAllStudents`).subscribe(data => {
      console.log(data);
      this.students = data;
    });
  }

  goBack(): void {
    this.location.back();
  }

  findStudent(): void {
// найти студента по имени
  }
}
