import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AddCart} from '../model/add-cart';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppUserService {

  constructor(private http: HttpClient) { }
  findUser(email: string): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/public/appUser?email=' + email);
  }

}
