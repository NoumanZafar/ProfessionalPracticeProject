import { Component, OnInit } from '@angular/core';
import { MovieService} from '../../Services/movie.service';

@Component({
  selector: 'app-view-movies',
  templateUrl: './view-movies.component.html',
  styleUrls: ['./view-movies.component.css']
})
export class ViewMoviesComponent implements OnInit {
  movies: any = [];

  constructor(private service: MovieService) { }

  //Reading from hardcoded json file(src\assets\movies.json)
  ngOnInit() {
    this.service.getMovieData().subscribe(data => 
      {
        this.movies = data.movies;
        console.log("In movies component "+ this.movies); 
       
  });
  }

}
