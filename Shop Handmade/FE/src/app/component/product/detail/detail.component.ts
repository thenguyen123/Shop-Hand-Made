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
import {render} from 'creditcardpayments/creditCardPayments';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  imgChange: string;
  pricesUSD: string;
  isLoggedIn = false;
  username: any;

  constructor(private productService: ProductService,
              private route: Router, private cartDetail: CardService,
              private activatedRoute: ActivatedRoute,
              private  appUser: AppUserService,
              private tokenStorageService: TokenStorageService,
              private cartService: CardService, private shareService: ShareService) {
  }

  quantityByIdProduct = 0;
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
  prices = 0;
  idBuy: number;
  flag = true;
  isCheck = true;
  cartDetails: Product [];
  checkQuantity = 0;

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      this.id = +param.get('id');
    });
    this.findById();
    this.findUserName();
    this.findIdCard();
    this.findCard();
    this.checkLogin();

  }

  findById() {
    this.productService.findById(this.id).subscribe(param => {
      this.products = param;
      this.imgProduct = this.products.imageList;
      this.imgChange = this.imgProduct[0].img;

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

  checkLogin(): void {
    if (this.tokenStorageService.getToken()) {
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
  }
  addCart(id: number) {
    this.findQuantity();
    this.checkQuantity = this.quantityByIdProduct + this.amount;
    if (this.checkQuantity > this.quantity) {
      Swal.fire({
        text: 'Số lượng sản phẩm đã đạt tới giới hạn.Giỏ hàng của bạn đã có ' + this.quantityByIdProduct + ' sản phẩm ',
        icon: 'error',
        showConfirmButton: false,
        timer: 1700
      });
    }
    if (this.quantity === 0) {
      Swal.fire({
        text: 'Sản phẩm hiện tại đã hết',
        icon: 'error',
        showConfirmButton: false,
        timer: 1700
      });
    } else if (this.checkQuantity <= this.quantity) {
      this.cart2 = {
        amount: this.amount,
        cart: {id: this.appUser2.idCard},
        product: {id},
      };
      console.log(this.cart2);
      this.cartService.addCart(this.cart2).subscribe(next => {
        this.countItems();
        this.findCard();
        Swal.fire({
          text: 'Thêm  thành công',
          icon: 'success',
          showConfirmButton: false,
          timer: 1500
        });
      });
    }
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
      Swal.fire({
        text: 'Số lượng tối thiểu là 1',
        icon: 'error',
        showConfirmButton: false,
        timer: 1700
      });
    }
  }
  add() {
    this.findQuantity();
    this.amount++;
    this.checkQuantity = this.quantityByIdProduct + this.amount;
    if (this.checkQuantity > this.quantity && this.quantityByIdProduct !== 0) {
        this.amount = this.quantity - this.quantityByIdProduct;
        Swal.fire({
          text: 'Số lượng sản phẩm đã đạt tới giới hạn.Giỏ hàng của bạn đã có ' + this.quantityByIdProduct + ' sản phẩm ',
          icon: 'error',
          showConfirmButton: false,
          timer: 1700
        });
      } else if (this.amount > this.quantity) {
      this.amount = this.quantity - this.quantityByIdProduct;
      Swal.fire({
          text: 'Số lượng sản phẩm trong kho không đủ ',
          icon: 'error',
          showConfirmButton: false,
          timer: 1700
        });
      }
  }

  changeAmount() {
    this.findQuantity();
    this.checkQuantity = this.quantityByIdProduct + this.amount;
    if (this.amount <= 0) {
      this.amount = 1;
      Swal.fire({
        text: 'Số lượng tối thiểu là 1',
        icon: 'error',
        showConfirmButton: false,
        timer: 1700
      });
    } else if (this.amount > this.quantity) {
      this.amount = this.quantity - this.quantityByIdProduct;
      Swal.fire({
        text: 'Số lượng sản phẩm trong kho không đủ ',
        icon: 'error',
        showConfirmButton: false,
        timer: 1700
      });
    } else if (this.checkQuantity > this.quantity && this.quantityByIdProduct !== 0) {
      this.amount = this.quantity - this.quantityByIdProduct;
      Swal.fire({
        text: 'Số lượng sản phẩm đã đạt tới giới hạn.Giỏ hàng của bạn đã có ' + this.quantityByIdProduct + ' sản phẩm ',
        icon: 'error',
        showConfirmButton: false,
        timer: 1700
      });
    }
  }

  payPal(product1: Product) {
    if (this.quantity === 0) {
      Swal.fire({
        text: 'Sản phẩm hiện tại đã hết',
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
    } else {
      this.isCheck = true;
      this.flag = false;
      this.prices = this.amount * product1.prices;
      this.idBuy = product1.id;
      this.renderPayPal(this.prices);
    }
  }

  renderPayPal(prices: number) {
    document.querySelector('#myPaypalButtons').innerHTML = '';
    this.pricesUSD = (prices / 23000).toFixed(1);
    render(
      {
        id: '#myPaypalButtons',
        currency: 'USD',
        value: this.pricesUSD,
        onApprove: (details => {
          this.buyProduct();

          document.querySelector('#myPaypalButtons').innerHTML = '';
          Swal.fire({
            text: 'Thanh toán thành công',
            icon: 'success',
            showConfirmButton: false,
            timer: 1500
          });
        })
      }
    );
  }


  buyProduct() {
    this.flag = true;
    this.cart2 = {
      amount: this.amount,
      cart: {id: this.appUser2.idCard},
      product: {id: this.idBuy},
    };
    console.log(this.cart2);
    this.cartService.fastBuy(this.cart2).subscribe(next => {
      this.findById();
      Swal.fire({
        text: 'Mua thành công',
        icon: 'success',
        showConfirmButton: false,
        timer: 1500
      });
    });
  }

  findCard() {
    this.cartDetail.findCart(this.nameUser).subscribe(param => {
      this.cartDetails = param;
    });
  }

  findQuantity() {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.cartDetails.length; i++) {
      if (this.id === this.cartDetails[i].id) {
        this.quantityByIdProduct = this.cartDetails[i].amount;
      }
    }
  }

  change(i: Image) {
    this.imgChange = i.img;
  }


}
