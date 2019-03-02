import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  pictures = [
    {
      id: 1,
      img: '../../../assets/images/addMovie.jpg',
      title: 'Add A Movie'
      
    },
    {
      id: 2,
      img: '../../../assets/images/actor.jpg',
      title: 'Add an Actor'
    },
    {
      id: 3,
      img: '../../../assets/images/view.jpg',
      title: 'View Movie Info'
  
    },
   
  ];
}



