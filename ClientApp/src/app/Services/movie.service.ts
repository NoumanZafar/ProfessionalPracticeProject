import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie} from '../Models/movie.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
 
  constructor(private http: HttpClient) { }
  uri='http://localhost:8080';

  getMovieData(): Observable<any> {
    return this.http.get(`${this.uri}/movies/list`);  
 }

 
addMovie(MOVIE_ID : number, MOVIE_TITLE: string,MOVIE_DESC: string, MOVIE_IMG: Blob,TRAILER: Blob, YEAROFRELEASE: Date,DIRECTOR_ID: number):Observable<any>{
const movie: Movie={MOVIE_ID: MOVIE_ID,MOVIE_TITLE: MOVIE_TITLE, MOVIE_DESC:MOVIE_DESC, MOVIE_IMG: MOVIE_IMG, TRAILER:TRAILER, YEAROFRELEASE: YEAROFRELEASE,DIRECTOR_ID: DIRECTOR_ID};
return this.http.post("http://localhost:8080/movies/list",movie);
  }

}
