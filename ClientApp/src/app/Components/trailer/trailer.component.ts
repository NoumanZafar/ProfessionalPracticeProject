import { Component, OnInit } from '@angular/core';
import { MovieService} from '../../Services/movie.service';

@Component({
  selector: 'app-trailer',
  templateUrl: './trailer.component.html',
  styleUrls: ['./trailer.component.css']
})
export class TrailerComponent implements OnInit {
  movies:any;
  constructor(private service: MovieService) { }

  ngOnInit() {
    this.service.getMovieData().subscribe(data=>{
      this.movies=data;
    })
  }
}
