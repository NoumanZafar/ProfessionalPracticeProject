import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Actor} from '../Models/actor.model';
import { Observable } from 'rxjs';
import { Binary } from 'selenium-webdriver/firefox';
import { utf8Encode } from '@angular/compiler/src/util';

@Injectable({
  providedIn: 'root'
})
export class ActorService {
  
  constructor(private http: HttpClient) { }
  uri='http://localhost:8080';
 
  file:File;
  base64textString:string;
  binaryString:string;
  sendData:string;


  getAll():Observable<any>{
    return this.http.get(`${this.uri}/actors/list`);
  }
  
 //Returns data from mysql database.
  getActorsData(): Observable<any> {
    return this.http.get(`${this.uri}/actors/list`);
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
       //console.log(btoa(this.base64textString));
}

addActor(actorID: any,actorFName: any,actorSurname: any, picture: any){
  const actor =[{"actorID": actorID, "actorFname": actorFName, "actorSurname": actorSurname, picture:this.base64textString}];
  
  let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
  console.log(actor)

  return this.http.post(`${this.uri}/actors/insert`, actor,{
    headers:headers});

}
}
  