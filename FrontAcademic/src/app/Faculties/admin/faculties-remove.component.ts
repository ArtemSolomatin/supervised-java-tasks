import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-faculties-remove',
  templateUrl: './faculties-remove.component.html',
  styleUrls: [ './faculties-add.component.css' ]
})
export class FacultiesRemoveComponent {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  faculties: any;
  facultyId: string;

// TODO не должно быть в коде localhost 8090, нужна какая-нибудь строка в другом файле, которую можно подставлять
  removeFaculty(): void {
    this.http.get(`http://localhost:8090/deleteFaculty?facultyId=` + this.facultyId)
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
