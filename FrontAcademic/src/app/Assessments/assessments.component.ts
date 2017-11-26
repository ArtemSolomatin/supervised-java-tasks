import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import {routes} from "../routes";

@Component({
  selector: 'app-assessments',
  templateUrl: './assessments.component.html',
  styleUrls: [ './assessments.component.css' ]
})
export class AssessmentsComponent implements OnInit{
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  assessments: any;

  ngOnInit(): void {
    console.log('Init');
    this.http.get(`${routes.gateway}/getAllAssessments`).subscribe(data => {
      console.log(data);
      this.assessments = data;
    });
  }

  goBack(): void {
    this.location.back();
  }
}
