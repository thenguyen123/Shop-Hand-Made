import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute} from '@angular/router';
import {Product} from '../../../model/product';
import {ProductDetail} from '../../../model/product-detail';
import {Image} from '../../../model/image';
import {FormControl, FormGroup} from '@angular/forms';
import {Cart} from '../../../model/cart';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  id: number;
  products: ProductDetail;
  imgProduct: Image[];
  cartAdd: FormGroup;
  cart: Cart;
  product: Product;
  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      this.id = +param.get('id');
    });
    this.findById();
    this.cartAdd = new FormGroup({
      id: new FormControl(),
      amount: new FormControl(),
      cart: new FormControl(),
      product: new FormControl(),
    });
  }

  findById() {
    this.productService.findById(this.id).subscribe(param => {
      this.products = param;
      this.imgProduct = this.products.imageList;
    });
  }
}
