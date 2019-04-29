import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';
import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { Routes, RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule,MatInputModule, MatToolbarModule, MatButtonModule,
  MatTableModule, MatCardModule,MatSidenavModule, MatListModule,MatPaginatorModule,
  MatSortModule,MatExpansionModule,MatMenuModule} from '@angular/material';
import {MatDividerModule} from '@angular/material/divider'
import { NgxSpinnerModule } from 'ngx-spinner';
import { LayoutModule } from '@angular/cdk/layout';
import { AddComponent } from './Components/add/add.component';
import { MovieService } from './Services/movie.service';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddActorComponent } from './Components/add-actor/add-actor.component';
import { ActorService } from './Services/actor.service';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ViewActorsComponent } from './Components/view-actors/view-actors.component';
import { ViewMoviesComponent } from './Components/view-movies/view-movies.component';
import { MatVideoModule } from 'mat-video';
import { TrailerComponent } from './Components/trailer/trailer.component';
import {ScrollingModule} from '@angular/cdk/scrolling';
import {MatSnackBarModule} from '@angular/material/snack-bar';


//Routing for the Component paths.
const appRoutes: Routes =[

  {
  path: 'add',
  component: AddComponent
  },
  {
    path: 'addActor',
    component: AddActorComponent
  },
  {
    //Change path when to homepage when done
    path: 'ViewActors',
    component: ViewActorsComponent
  },
  {
  //Change path when to homepage when done
  path: 'ViewMovies',
  component: ViewMoviesComponent
},
{
//Change path when to homepage when done
path: 'Trailers',
component: TrailerComponent
}
  

  ///////More Routes Here///////
]

@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    AddActorComponent,
    ViewActorsComponent,
    ViewMoviesComponent,
    TrailerComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatIconModule,
    MatFormFieldModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatListModule,
    MatInputModule,
    RouterModule.forRoot(appRoutes),
    MatDividerModule,
    FormsModule,
    MatCardModule,
    FlexLayoutModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    NgxSpinnerModule,
    HttpClientModule,
    MatExpansionModule,
    MatMenuModule,
    MatVideoModule,
    ScrollingModule,
    MatSnackBarModule
    
    
  ],
  providers:
   [
  MovieService,ActorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
