import { Component } from '@angular/core';
import { NgxSpinnerService } from 'ngx-spinner';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Movie Database';
  numbers: number[] = [];


  constructor() {
    for (let index = 0; index < 10000; index++) {
      this.numbers.push(index);
    }
}



}
