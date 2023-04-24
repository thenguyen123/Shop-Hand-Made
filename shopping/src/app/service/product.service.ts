import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ObserveOnSubscriber} from 'rxjs/internal/operators/observeOn';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {ProductDetail} from '../model/product-detail';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
  }

  findAll(page: number, size: number): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/user/product/list?page=' + page + '&size=' + size);
  }

  findById(id: number): Observable<ProductDetail> {
    return this.http.get<ProductDetail>('http://localhost:8080/api/user/product/detail?id=' + id);
  }
}
