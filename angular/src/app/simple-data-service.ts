import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SimpleData } from './simpledata';

@Injectable({
  providedIn: 'root'
})
export class SimpleDataService {
  private dataUrl = 'http://localhost:8080/SimpleDemoApp/home';

  constructor(private http: HttpClient) {}

  public getData(): Observable<SimpleData> {
    return this.http.get<SimpleData>(this.dataUrl);
  }
}
