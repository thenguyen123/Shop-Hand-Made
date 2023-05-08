import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CartDetail} from '../model/cart-detail';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  constructor(private http: HttpClient) {
  }

  addCart(cartDetail: CartDetail) {
    return this.http.post('http://localhost:8080/api/public/cart/add', cartDetail);
  }

  changeAmount(id: number, amount: number): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/public/cart/add2?id=' + id + '&amount=' + amount);
  }

  deleteCartDetail(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/public/cart/delete?id=' + id);
  }

  payPal(idCart: number): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/public/payPal?idCart=' + idCart);
  }
  findCart(userName: string): Observable<any> {
    return this.http.get<any>
    ('http://localhost:8080/api/public/cart?userName=' + userName);
  }

  findBuy(userName: string): Observable<any> {
    return this.http.get<any>
    ('http://localhost:8080/api/public/cart/history?userName=' + userName);
  }
}
