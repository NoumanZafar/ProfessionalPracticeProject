import { Component, OnInit } from '@angular/core';
import { MovieService} from '../../Services/movie.service';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-view-movies',
  templateUrl: './view-movies.component.html',
  styleUrls: ['./view-movies.component.css']
})
export class ViewMoviesComponent implements OnInit {
  movies:Array<any>;
  constructor(private service: MovieService,private spinner: NgxSpinnerService) { }

  ngOnInit() {
      /** spinner starts on init */
      this.spinner.show();

      setTimeout(() => {
          /** spinner ends after 15 seconds ,ADJUST THIS LATER*/
          this.spinner.hide();
      }, 7000);
    
    this.service.getMovieData().subscribe(data=>{
      this.movies=data;
    });
  }
  onDeleteMovie(movieID: any){
    console.log("Hi from movieDelete "+movieID);
    this.service.deleteMovie(movieID).subscribe(() =>{
      this.ngOnInit;
    });
  }

    viewMovie(){
      this.service.getMovieData().subscribe(data=>{
        this.movies=data;
      });




  /*onDeleteMovie(movieID: string){
    console.log("Hi from movieDelete "+movieID);
    this.service.deleteMovie(movieID).subscribe(() =>{
      this.ngOnInit;
    });*/

    /*onDeleteMovie(id:String){
      console.log("Hi from movieDelete "+id);
      this.service.deleteMovie(id).subscribe(() =>{
        this.ngOnInit();
 });*/

  }
}
