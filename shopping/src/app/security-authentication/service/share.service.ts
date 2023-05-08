import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable, Subject} from 'rxjs';
import {ProductService} from '../../service/product.service';
import {TokenStorageService} from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class ShareService {
   count = 0;
   nameUser: string;

  constructor(private productService: ProductService , private tokenStorageService: TokenStorageService) { }
  private subject = new Subject<any>();
  itemCount: BehaviorSubject<any> = new BehaviorSubject<number>(0);

  sendClickEvent() {
    this.subject.next();
  }

  getClickEvent(): Observable<any> {
    return this.subject.asObservable();
  }

  getCount(): Observable<any> {
    return this.itemCount.asObservable();
  }

  setCount(count: number): void {
    this.itemCount.next(count);
  }


}
