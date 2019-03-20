import { Component, OnInit } from '@angular/core';
import { MovieService} from '../../Services/movie.service';

@Component({
  selector: 'app-view-movies',
  templateUrl: './view-movies.component.html',
  styleUrls: ['./view-movies.component.css']
})
export class ViewMoviesComponent implements OnInit {
  movies:Array<any>;
  constructor(private service: MovieService) { }

  //Reading from hardcoded json file(src\assets\movies.json)
  ngOnInit() {
    //made changes here this.movies is an array which takes the whole json data not individual column.
    //so whenever json is being read, read the whole array and store it in the array created here (movies)
    this.service.getMovieData().subscribe(data=>{
      this.movies=data;
    })
  }
}
