import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import {TokenStorageService} from '../../../security-authentication/service/token-storage.service';

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

  constructor(private productService: ProductService, private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.findUserName();
    this.productService.findCard(this.nameUser, this.page, this.size).subscribe(param => {
      this.products = param.content;
      console.log(this.products);
      this.pageCount = param.totalPages;
      this.findImage();
    });
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
