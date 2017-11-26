import { Component } from '@angular/core';
import { ActivatedRoute} from '@angular/router';
import { Location } from '@angular/common';
import {HttpClient} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {routes} from "../../routes";
import {isNullOrUndefined} from "util";

@Component({
  selector: 'app-subjects-remove',
  templateUrl: './subjects-remove.component.html',
  styleUrls: [ '../subjects.component.css' ]
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
    if (isNullOrUndefined(this.subjectId)) {
      alert('Какое-то поле не проставлено');
      return;
    }
    this.http.get(`${routes.gateway}/deleteSubject?subjectId=${this.subjectId}`)
      .subscribe(data => {
        console.log(data);
        this.subjects = data;
      });
    this.subjectId = '';
  }

  goBack(): void {
    this.location.back();
  }
}
