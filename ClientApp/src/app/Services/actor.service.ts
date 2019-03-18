import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Actor} from '../Models/actor.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ActorService {
  
  constructor(private http: HttpClient) { }
  
  //Testing functionality of table with hardcoded json before trying database
  getActorsData(): Observable<any> {
  return this.http.get('https://jsonblob.com/api/480fc466-4378-11e9-a39b-e90caae17eb2');
 }

 // }
/*addActor(ACTOR_ID : number,FIRST_NAME: string,SURNAME: string ):Observable<any>{
  const actor: Actor={ACTOR_ID: ACTOR_ID, FIRST_NAME:FIRST_NAME,SURNAME:SURNAME};
  return this.http.post("http://localhost:8081/api/actors",actor);
}*/
}
