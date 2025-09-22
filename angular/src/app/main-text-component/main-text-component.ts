import { Component, OnInit } from '@angular/core';
import { SimpleData } from '../simpledata';
import { SimpleDataService } from '../simple-data-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-main-text-component',
  standalone: true,
  imports: [
    CommonModule,
  ],
  template: `
    <p>
      A simple angular application. Pressing the following button will:
    </p>
    <ol>
      <li>Angular will send a get Request to the Spring Boot Server</li>
      <li>The server will receive the request and pull some text from the Firestore database</li>
      <li>The server will send the queried data back to Angular</li>
      <li>Angular will update the browser with the new information to display</li>
    </ol>

    <button class="primary" *ngIf="showButton" type="button" (click)="fetchData()">Pull From The Database</button>

    <p *ngIf="loading">Loading...</p>

    <div *ngIf="data as d">
      <p> data1: {{ d.data1 }}</p> 
      <p> data2: {{ d.data2 }}</p>
    </div>

  `,
  styleUrl: './main-text-component.css'
})
export class MainTextComponent{
  data?: SimpleData;
  showButton = true;
  loading = false;

  constructor(private simpleDataService: SimpleDataService){}

  fetchData(){
    this.showButton = false;   // hide the button
    this.loading = true;       // optional: show "loading..."
    this.simpleDataService.getData().subscribe({
      next: d => {
        this.data = d;
        this.loading = false;
      },
      error: err => {
        console.error('Error fetching data', err);
        this.loading = false;
        this.showButton = true; // let user retry on error
      }
    });
  }
}
