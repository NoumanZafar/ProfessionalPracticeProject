  import { Injectable } from '@angular/core';
  import { HttpClient,HttpHeaders } from '@angular/common/http';
  import { Observable } from 'rxjs';
import { Actor } from '../Models/director.model';

  @Injectable({
    providedIn: 'root'
  })
  export class ActorService {

    private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
    
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
      
  }

  addActor(actorID,actorFName,actorSurname){
    const actor = [{
      "actorID" : actorID, 
      "actorFname" : actorFName, 
      "actorSurname" : actorSurname, 
      "picture" : this.base64textString
    }];
    
    let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
    console.log(actor)

    return this.http.post(`${this.uri}/actors/insert`, actor,{
      headers:headers
    });

    }
    
    deleteActor(actorID){
      const actor = [{
        "actorID" : actorID
      }];
      
      let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
      console.log(actor)
  
      return this.http.post(`${this.uri}/actors/delete`, actor,{
        headers:headers
      });
  
      }
  
/*
  deleteActor(actorID:any){
    let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
    headers.append('X-Requested-With', 'XMLHttpRequest');
    return this.http.post(`${this.uri}/actors/delete`+actorID,{ responseType: 'json' });

  }*/
}

   /* deleteActor(actorID: String): Observable<any>{
       let headers: Headers = new Headers({'Content-Type':'application/json; charset=UTF-8'});
     // let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
         headers.append('Content-Type', 'application/json');
         headers.append('X-Requested-With', 'XMLHttpRequest');
      return this.http.delete(`${this.uri}/actors/delete/${actorID}`,{ responseType: 'text' });*/
    
    //DELETE ACTOR
    //deleteActor(actorID): Observable<any>{
     // let headers: HttpHeaders=new HttpHeaders({'Content-Type':'application/json; charset=UTF-8'});
      //return this.http.delete(`${this.uri}/actors/delete`, { responseType: 'text' }, actorID)
     //   headers: headersDelete
         
      //});
    
  
