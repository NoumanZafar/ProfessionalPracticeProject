import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Actor} from '../Models/actor.model';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ActorService {
   private actors: Actor[] =[];

  constructor(private http: HttpClient) { }
  //Testing functionality of table with hardcoded json before trying database
 

  getActorsDetails(): Observable<any> {
    return this.http.get("https://jsonblob.com/725492f6-40c9-11e9-a8cb-7fc5761c93b1");
}
 // getActors() {
  //  return [...this.actors];

 // }
/*addActor(ACTOR_ID : number,FIRST_NAME: string,SURNAME: string ):Observable<any>{
  const actor: Actor={ACTOR_ID: ACTOR_ID, FIRST_NAME:FIRST_NAME,SURNAME:SURNAME};
  return this.http.post("http://localhost:8081/api/actors",actor);
}*/
}
