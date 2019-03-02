import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Actor} from '../Models/actor.model';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class ActorService {

  constructor(private http: HttpClient) { }

  private actors: Actor[] =[];

  getActors() {
    return [...this.actors];

  }
addActor(ACTOR_ID : number,FIRST_NAME: string,SURNAME: string ):Observable<any>{
  const actor: Actor={ACTOR_ID: ACTOR_ID, FIRST_NAME:FIRST_NAME,SURNAME:SURNAME};
  return this.http.post("http://localhost:8081/api/actors",actor);
}
}
