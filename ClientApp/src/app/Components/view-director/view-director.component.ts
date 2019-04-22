import { Component, OnInit } from '@angular/core';
import {DirectorService} from '../../Services/director.service';

@Component({
  selector: 'app-view-director',
  templateUrl: './view-director.component.html',
  styleUrls: ['./view-director.component.css']
})
export class ViewDirectorComponent implements OnInit {

  constructor(private service: DirectorService) { }

  directors:Array<any>;


  ngOnInit() {
    this.service.getDirectorsData().subscribe(data => 
      {
        this.directors = data;
    });

  }
}

        
