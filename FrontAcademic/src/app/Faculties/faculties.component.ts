import { Component, OnInit } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import {routes} from "../routes";

@Component({
  selector: 'app-faculties',
  templateUrl: './faculties.component.html',
  styleUrls: [ './faculties.component.css' ]
})
export class FacultiesComponent implements OnInit {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  faculties: any;

  ngOnInit(): void {
    console.log('Init');
    this.http.get(`${routes.gateway}/getAllFaculties`).subscribe(data => {
      console.log(data);
      this.faculties = data;
    });
  }

  goBack(): void {
    this.location.back();
  }
}
