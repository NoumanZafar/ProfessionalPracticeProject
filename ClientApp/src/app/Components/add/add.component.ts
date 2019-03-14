import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/app/Services/movie.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private service: MovieService) { }

  onAddMovie(form: NgForm){
    
    if (form.valid){
      this.service.addMovie(form.value.MOVIE_ID,form.value.MOVIE_TITLE,form.value.MOVIE_DESC,
        form.value.MOVIE_IMG,form.value.TRAILER, form.value.YEAROFRELEASE, form.value.DIRECTOR_ID).subscribe();

        console.log(form.value);
      //  form.resetForm();
    }else{
      
      return;
    }
  }

  ngOnInit() {
  }

}
