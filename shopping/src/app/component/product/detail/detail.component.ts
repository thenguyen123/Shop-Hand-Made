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
import {ShareService} from '../../../security-authentication/service/share.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  id: number;
  products: ProductDetail;
  imgProduct: Image[];
  cart: Cart;
  product: Product;
  amount = 1;
  nameUser: string;
  appUser2: AppUser;
  cart2: CartDetail;
  count = 0;
  quantity = 0;

  constructor(private productService: ProductService,
              private route: Router,
              private activatedRoute: ActivatedRoute,
              private  appUser: AppUserService,
              private tokenStorageService: TokenStorageService,
              private cartService: CardService, private shareService: ShareService) {
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
      this.quantity = this.products.product.quantity;
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
    this.cart2 = {
      amount: this.amount,
      cart: {id: this.appUser2.idCard},
      product: {id},
    };
    console.log(this.cart2);
    this.cartService.addCart(this.cart2).subscribe(next => {
      Swal.fire({
        text: 'Thêm thành công',
        icon: 'success',
        showConfirmButton: false,
        timer: 1500
      });
      this.countItems();
    });
  }

  countItems() {
    this.cartService.findCart(this.nameUser).subscribe(param => {
      this.count = param.length;
      this.shareService.setCount(this.count);
    });
  }

  subtract() {
    if (this.amount > 1) {
      this.amount--;
    } else {
      Swal.fire('Số lượng hàng tối thiểu là 1 ');
    }
  }

  add() {
    if (this.quantity > this.amount) {
      this.amount++;
    } else {
      Swal.fire('Số lượng hàng trong kho không đủ ');
    }

  }

}
