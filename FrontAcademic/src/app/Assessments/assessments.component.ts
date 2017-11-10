import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {Http} from '@angular/http';
import {HttpClient, HttpClientModule} from '@angular/common/http';

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
    this.http.get('http://localhost:8090/getAllAssessments').subscribe(data => {
      console.log(data);
      this.assessments = data;
    });
  }

  goBack(): void {
    this.location.back();
  }

  findAssessments(): void {
// найти assessment по имени студента
  }
}
