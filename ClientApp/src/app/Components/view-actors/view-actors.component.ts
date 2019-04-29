import { Component, OnInit } from '@angular/core';
import { ActorService } from '../../Services/actor.service';
import { Actor } from 'src/app/Models/actor.model';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-actors',
  templateUrl: './view-actors.component.html',
  styleUrls: ['./view-actors.component.css']
})
export class ViewActorsComponent implements OnInit {
  actors: Array<any>;

  constructor(private service: ActorService) { }

  ngOnInit() {
    this.service.getActorsData().subscribe(data => {
      this.actors = data;
      console.log("In actors component " + data);

    });

}

//}
 onDeleteActor(actorID: any){
    console.log("Hi from "+ this.actors);
   this.service.deleteActor(actorID).subscribe(() =>{
     console.log("actor deleted")
     //this.ngOnInit();
   });
  }
}

/*  onDeleteActor(actorID) {
    console.log("Hi from "+ actorID);
    this.service.deleteActor(actorID).subscribe(() =>{
       this.ngOnInit();
}); */


