import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import {TokenStorageService} from '../../../security-authentication/service/token-storage.service';
import {render} from 'creditcardpayments/creditCardPayments';
import {CardService} from '../../../service/card.service';
import Swal from 'sweetalert2';
import {ShareService} from '../../../security-authentication/service/share.service';
import {CurrencyPipe} from '@angular/common';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  products: Product [];
  size = 5;
  pageCount = 0;
  nameUser = '';
  totalPrices = 0;
  items = 0;
  amount = 0;
  name = '';
  id: number;
  idCart: number;
  flag = true;
  idDetails: number [] = [];
  count = 0;
  pricesUSD: string;

  constructor(private productService: ProductService, private tokenStorageService: TokenStorageService,
              private cartDetail: CardService,
              private  shareService: ShareService) {

  }

  ngOnInit(): void {
    this.findUserName();
    this.findCard();
  }

  payPal() {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.idDetails.length; i++) {
      this.cartDetail.payPal(this.idDetails[i]).subscribe(() => {
      }, error => {
        Swal.fire({
          text: 'Thanh toán không thành công',
          icon: 'error',
          showConfirmButton: false,
          timer: 1500
        });
      });
    }
  }

  findCard() {
    this.cartDetail.findCart(this.nameUser).subscribe(param => {
      this.products = param;
      this.items = this.products.length;
      this.idCart = this.products[0].idCart;
      this.pageCount = param.totalPages;
      this.resetCart(this.items);
      this.findImage();
      this.findTotalPrices();
    });
  }

  resetCart(length: number) {
    this.shareService.setCount(length);
  }

  findTotalPrices() {
    this.flag = false;
    // tslint:disable-next-line:prefer-for-of
    this.totalPrices = 0;
    this.count = this.idDetails.length;
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.idDetails.length; i++) {
      // tslint:disable-next-line:prefer-for-of
      for (let j = 0; j < this.products.length; j++) {
        if (this.products[j].idDetail === this.idDetails[i]) {
          this.totalPrices += this.products[j].amount * this.products[j].prices;
        }
      }
    }
    this.renderPayPal(this.totalPrices);
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
          this.payPal();
          Swal.fire({
            text: 'Thanh toán thành công',
            icon: 'success',
            showConfirmButton: false,
            timer: 1500
          });
          this.findCard();
        })
      }
    );
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

  changeAmount(id, amount) {
    this.cartDetail.changeAmount(id, amount).subscribe(pama => {
    });
  }

  subtraction(p: Product) {
    this.totalPrices = 0;
    p.amount--;
    this.amount = p.amount;
    this.changeAmount(p.idDetail, this.amount);
  }

  add(p: Product) {
    this.totalPrices = 0;
    p.amount++;
    this.amount = p.amount;
    this.changeAmount(p.idDetail, this.amount);
  }

  confirm(idDetail: number, name: string) {
    this.id = idDetail;
    this.name = name;
  }

  deleteCartDetail() {
    this.cartDetail.deleteCartDetail(this.id).subscribe(() => {
      Swal.fire({
        text: 'Xóa thành công',
        icon: 'success',
        showConfirmButton: false,
        timer: 1500
      });
      this.findCard();
    }, error => {
      Swal.fire({
        text: 'Xóa thất bại',
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
    });
  }

  changeChoose(p: Product) {
    if (this.idDetails.includes(p.idDetail)) {
      this.idDetails.splice(this.idDetails.indexOf(p.idDetail), 1);
      this.findTotalPrices();
    } else {
      this.idDetails.push(p.idDetail);
      this.findTotalPrices();
    }
  }

  inputAmount(p: Product, value: string) {
    this.amount = +value;
    if (this.amount <= 0) {
      this.amount = 1;
      Swal.fire({
        text: 'Số lượng tối thiểu là 1',
        icon: 'error',
        showConfirmButton: false,
        timer: 1700
      });
    } else if (this.amount > p.quantity) {
      p.amount = p.quantity;
      Swal.fire({
        text: 'Số lượng sản phẩm trong kho không đủ ',
        icon: 'error',
        showConfirmButton: false,
        timer: 1700
      });
    } else if (this.amount <= p.quantity) {
      this.amount = p.amount;
      this.changeAmount(p.idDetail, this.amount);
    }
  }
}
