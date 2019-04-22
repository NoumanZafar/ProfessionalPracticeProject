import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DirectorService {

  constructor(private http: HttpClient) { }
  uri='http://localhost:8080';

  directorfile:File;
  base64DirtextString:string;
  binaryString:string;
  sendData:string;

  getAll():Observable<any>{
    return this.http.get(`${this.uri}/directors/list`);
  }
  
  getDirectorsData(): Observable<any> {
    return this.http.get(`${this.uri}/directors/list`);
 }
 onDirFileSelected(event){
  var files=event.target.files;
  this.directorfile=files[0];
  if(files && this.directorfile){
    var reader=new FileReader();
    reader.onload=this._handleReaderLoaded.bind(this);
    reader.readAsBinaryString(this.directorfile);
  }
}
  addActor(dirID,dirFName,dirSname){
    const actor = [{
      "DIRECTOR_ID" : dirID, 
      "DIRFNAME" : dirFName, 
      "DIRSNAME" : dirSname, 
      "PICTURE" : this.base64DirtextString
    }];
}

_handleReaderLoaded(readerEvt) {
       this.binaryString = readerEvt.target.result;
       this.base64DirtextString= btoa(this.binaryString);
}
}
