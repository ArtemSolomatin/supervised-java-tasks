import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {RoutingModule} from './routing.module';
import {StudentsComponent} from './Students/students.component';
import {StartPageComponent} from './StartPage/start-page.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentsComponent,
    StartPageComponent,
  ],
  imports: [
    BrowserModule,
    RoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
