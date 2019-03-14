import { Component, OnInit } from '@angular/core';
import { ActorService} from '../../Services/actor.service';
import { Actor } from 'src/app/Models/actor.model';
import { ActivatedRoute } from '@angular/router';
import { Observable} from 'rxjs';

@Component({
  selector: 'app-view-actors',
  templateUrl: './view-actors.component.html',
  styleUrls: ['./view-actors.component.css']
})
export class ViewActorsComponent implements OnInit {
  actors: any[];

  constructor(private service: ActorService) { }

  ngOnInit() {
    
   this.service.getActorsDetails().subscribe(data => 
    {
      this.actors = data.actors;
      console.log("in view actors comp..." + this.actors );

    
});
  }

}
