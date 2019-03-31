import { Component, OnInit } from '@angular/core';
import {ActorService} from '../../Services/actor.service';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-actor',
  templateUrl: './add-actor.component.html',
  styleUrls: ['./add-actor.component.css']
})
export class AddActorComponent implements OnInit {

  constructor(private service: ActorService, private http: HttpClient) { }
  list:any;
  public file:File=null;
  
  onFileSelected(event){
    this.service.onFileSelected(event);
  }
  onAddActor(form:NgForm){
    if(form.valid){
      this.service.addActor(form.value.actorID,form.value.actorFName,form.value.actorSurname,form.value.picture).subscribe();
      console.log(form.value);
      form.resetForm();
      } else {
        return;
      }
    }
    ngOnInit(){
  }
}

