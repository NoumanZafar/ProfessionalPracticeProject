import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Movie} from '../Models/movie.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
  export class MovieService {
  
    constructor(private http: HttpClient) { }
    uri='http://localhost:8080';

    file:File;
    base64textString:string;
    binaryString:string;
    sendData:string;

    getAllMovies():Observable<any>{
      return this.http.get(`${this.uri}/movies/list`);
    }
    getMovieData(): Observable<any> {
      return this.http.get(`${this.uri}/movies/list`);
  }
  onFileSelected(event){
    var files=event.target.files;
    this.file=files[0];
    if(files && this.file){
      var reader=new FileReader();
      reader.onload=this._handleReaderLoaded.bind(this);
      reader.readAsBinaryString(this.file);
    }
  }
  _handleReaderLoaded(readerEvt) {
    this.binaryString = readerEvt.target.result;
    this.base64textString= btoa(this.binaryString);

  }
  addMovie(movieID,movieTitle,movieDesc,movieReleaseYear,directorID){
    const movie= [{
      "movieID":  movieID,
      "movieTitle": movieTitle,
      "movieDesc": movieDesc,
      "movieImage": this.base64textString,
      "movieTrailer": this.base64textString,
      "movieReleaseYear": movieReleaseYear,
      "directorID": directorID
    }];
    let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
    console.log(movie)

    return this.http.post(`${this.uri}/movies/insert`, movie,{
      headers:headers
    });
  }
}


