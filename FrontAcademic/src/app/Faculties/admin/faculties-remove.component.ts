import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {routes} from '../../routes';
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-faculties-remove',
  templateUrl: './faculties-remove.component.html',
  styleUrls: [ '../faculties.component.css' ]
})
export class FacultiesRemoveComponent {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  faculties: any;
  facultyId: string;

  removeFaculty(): void {
    if (isNullOrUndefined(this.facultyId)) {
      alert('Какое-то поле не проставлено');
      return;
    }
    this.http.get(`${routes.gateway}/deleteFaculty?facultyId=${this.facultyId}`)
      .subscribe(data => {
        console.log(data);
        this.faculties = data;
      });
    this.facultyId = '';
  }

  goBack(): void {
    this.location.back();
  }
}
