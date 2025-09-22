import { Component } from '@angular/core';

@Component({
  selector: 'app-main-text-component',
  standalone: true,
  imports: [],
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
  `,
  styleUrl: './main-text-component.css'
})
export class MainTextComponent {

}
