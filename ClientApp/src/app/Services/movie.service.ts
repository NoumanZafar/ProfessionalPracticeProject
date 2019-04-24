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

    // file:File;
      videofile:File;
      imgfile:File;
      base64ImgTextString:string;
      base64VideotextString:string;
      binaryString:string;
      sendData:string;

      getAllMovies():Observable<any>{
        return this.http.get(`${this.uri}/movies/list`);
      }
      getMovieData(): Observable<any> {
        return this.http.get(`${this.uri}/movies/list`);
    }
    onVideoFileSelected(event){
      var files=event.target.files;
      this.videofile=files[0];
      if(files && this.videofile){
        var reader=new FileReader();
        reader.onload=this._handleReaderLoaded.bind(this);
        reader.readAsBinaryString(this.videofile);
      }
    }
    _handleReaderLoaded(readerEvt) {
      this.binaryString = readerEvt.target.result;
      this.base64VideotextString= btoa(this.binaryString);
    }

    onImgFileSelected(event){
      var files=event.target.files;
      this.imgfile=files[0];
      if(files && this.imgfile){
        var reader=new FileReader();
        reader.onload=this._handleImgReaderLoaded.bind(this);
        reader.readAsBinaryString(this.imgfile);
      }
    }
    _handleImgReaderLoaded(readerEvt) {
      this.binaryString = readerEvt.target.result;
      this.base64ImgTextString= btoa(this.binaryString);
    }

    addMovie(movieID,movieTitle,movieDesc,movieReleaseYear,directorID){
      const movie= [{
        "movieID":  movieID,
        "movieTitle": movieTitle,
        "movieDesc": movieDesc,
        "movieImage": this.base64ImgTextString,
        "movieTrailer": this.base64VideotextString,
        "movieReleaseYear": movieReleaseYear,
        "directorID": directorID
      }];
      let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
      console.log(movie)

      return this.http.post(`${this.uri}/movies/insert`, movie,{
        headers:headers
      });
    }

  deleteMovie(movieID: String): Observable<any>{
      let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
      return this.http.post(`${this.uri}/movies/delete/`+ movieID,{
        headers:headers
       });
    }

      /*deleteMovie(movieID): Observable<any>{
      let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
      return this.http.post(`${this.uri}/movies/delete/`+ movieID,{
        headers:headers
       });
    }*/

    
  }


