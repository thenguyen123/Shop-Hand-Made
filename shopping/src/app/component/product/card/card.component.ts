import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import {TokenStorageService} from '../../../security-authentication/service/token-storage.service';
import {render} from 'creditcardpayments/creditCardPayments';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  products: Product [];
  page = 0;
  size = 5;
  pageCount = 0;
  nameUser = '';
  totalPrices = 0;
  items = 0;

  constructor(private productService: ProductService, private tokenStorageService: TokenStorageService) {

  }

  ngOnInit(): void {
    render(
      {
        id: '#myPaypalButtons',
        currency: 'USA',
        value: '100.00',
        onApprove: (details => {
          alert('thành công');
        })
      }
    );
    this.findUserName();
    this.productService.findCard(this.nameUser, this.page, this.size).subscribe(param => {
      this.products = param.content;
      this.items = this.products.length;
      console.log(this.products);
      this.pageCount = param.totalPages;
      this.findImage();
      this.sumPrices();
    });
  }

  sumPrices() {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.products.length; i++) {
      this.totalPrices += this.products[i].amount * this.products[i].prices;
    }
  }

  findImage() {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.products.length; i++) {
      this.productService.findById(this.products[i].id).subscribe(param => {
        this.products[i].img = param.imageList;
      });
    }
  }

  findUserName() {
    this.nameUser = this.tokenStorageService.getUser().username;
  }

}
