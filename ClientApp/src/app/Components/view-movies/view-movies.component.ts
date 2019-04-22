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

  ngOnInit() {
    this.service.getMovieData().subscribe(data=>{
      this.movies=data;
    })
  }
}
