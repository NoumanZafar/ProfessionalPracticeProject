import { Component, OnInit } from '@angular/core';
import { MovieService} from '../../Services/movie.service';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-trailer',
  templateUrl: './trailer.component.html',
  styleUrls: ['./trailer.component.css']
})
export class TrailerComponent implements OnInit {
  movies:any;
  constructor(private service: MovieService,private spinner: NgxSpinnerService) { } 
  ngOnInit() {
     this.spinner.show();

     setTimeout(() => {
         this.spinner.hide();
     }, 20000);
   
    this.service.getMovieData().subscribe(data=>{
      this.movies=data;
    });
  }
}