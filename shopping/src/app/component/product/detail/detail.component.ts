import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Product} from '../../../model/product';
import {ProductDetail} from '../../../model/product-detail';
import {Image} from '../../../model/image';
import {FormControl, FormGroup} from '@angular/forms';
import {Cart} from '../../../model/cart';
import {AddCart} from '../../../model/add-cart';
import {AppUser} from '../../../model/app-user';
import {AppUserService} from '../../../service/app-user.service';
import {TokenStorageService} from '../../../security-authentication/service/token-storage.service';
import {CardService} from '../../../service/card.service';
import Swal from 'sweetalert2';
import {CartDetail} from '../../../model/cart-detail';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  id: number;
  products: ProductDetail;
  imgProduct: Image[];
  cartAdd1: FormGroup;
  cart: Cart;
  cartAdd: AddCart;
  product: Product;
  amount = 1;
  nameUser: string;
  appUser2: AppUser;
  cart2: CartDetail;

  constructor(private productService: ProductService,
              private route: Router,
              private activatedRoute: ActivatedRoute,
              private  appUser: AppUserService,
              private tokenStorageService: TokenStorageService,
              private cartService: CardService) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      this.id = +param.get('id');
    });
    this.findById();

    this.findUserName();
    this.findIdCard();
  }

  findById() {
    this.productService.findById(this.id).subscribe(param => {
      this.products = param;
      this.imgProduct = this.products.imageList;
    });
  }

  findUserName() {
    this.nameUser = this.tokenStorageService.getUser().username;
  }

  findIdCard() {
    this.appUser.findUser(this.nameUser).subscribe(param => {
      this.appUser2 = param;
    });
  }

  addCart(id: number) {
    //
    // this.cartAdd1 = new FormGroup({
    //   amount: new FormControl(this.amount),
    //   cart: new FormControl(this.appUser2),
    //   product: new FormControl(id),
    // });
    this.cart2 = {
      amount: this.amount,
      cart: {id: this.appUser2.idCard},
      product: {id},
    };
    console.log(this.cart2);
    this.cartService.addCart(this.cart2).subscribe(next => {
      alert('thành công');
    });
  }

  subtract() {
    this.amount--;
  }

  add() {
    this.amount++;
  }
}
