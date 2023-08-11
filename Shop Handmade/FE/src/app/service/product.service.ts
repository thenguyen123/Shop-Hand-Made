import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ObserveOnSubscriber} from 'rxjs/internal/operators/observeOn';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {ProductDetail} from '../model/product-detail';
import {AddCart} from '../model/add-cart';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
  }

  findById(id: number): Observable<ProductDetail> {
    return this.http.get<ProductDetail>('http://localhost:8080/api/public/product/detail?id=' + id);
  }

  search(name: string, page: number, size: number, idTypes: number): Observable<any> {
    return this.http.get<any>
    ('http://localhost:8080/api/public/product/search?page=' + page + '&size=' + size + '&name=' + name + '&idTypes=' + idTypes);
  }




}
