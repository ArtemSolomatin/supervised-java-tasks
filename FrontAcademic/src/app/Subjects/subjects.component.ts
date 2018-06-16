import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import {routes} from "../routes";

@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styleUrls: [ './subjects.component.css' ]
})
export class SubjectsComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  subjects: any;

  ngOnInit(): void {
    console.log('Init');
    this.http.get(`${routes.gateway}/getAllSubjects`).subscribe(data => {
      console.log(data);
      this.subjects = data;
    });
  }

  goBack(): void {
    this.location.back();
  }
}
