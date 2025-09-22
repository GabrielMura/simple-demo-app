import { Component } from '@angular/core';
import { MainTextComponent } from './main-text-component/main-text-component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    MainTextComponent,
  ],
  template: `
  <main>
    <header>
      <h1>Hello T-Mobile!</h1>
    </header>
    <section class="content">
      <app-main-text-component></app-main-text-component>
    </section>
  </main>
  `,
  styleUrls: ['./app.component.css'],
})

export class AppComponent {
  title = 'Simply Angular';
}