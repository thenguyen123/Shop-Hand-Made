import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CartDetail} from '../model/cart-detail';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  constructor(private http: HttpClient) { }
  addCart(cartDetail: CartDetail) {
    return this.http.post('http://localhost:8080/api/public/cart/add', cartDetail);
  }

}
