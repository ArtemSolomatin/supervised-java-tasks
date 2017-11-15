import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-subjects-remove',
  templateUrl: './subjects-remove.component.html',
  styleUrls: [ './subjects-add.component.css' ]
})
export class SubjectsRemoveComponent {
  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private http: HttpClient
  ) {}

  subjects: any;
  subjectId: string;

  removeSubject(): void {
    this.http.get(`http://localhost:8090/deleteSubject?subjectId=` + this.subjectId)
      .subscribe(data => {
        console.log(data);
        this.subjects = data;
      });
  }

  goBack(): void {
    this.location.back();
  }
}
