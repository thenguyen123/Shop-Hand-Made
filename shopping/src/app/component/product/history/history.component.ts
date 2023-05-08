import {Component, OnInit} from '@angular/core';
import {Product} from '../../../model/product';
import {ProductService} from '../../../service/product.service';
import {TokenStorageService} from '../../../security-authentication/service/token-storage.service';
import {CardService} from '../../../service/card.service';
import {ShareService} from '../../../security-authentication/service/share.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  products: Product [];
  size = 5;
  nameUser = '';
  totalPrices = 0;
  items = 0;
  name = '';
  id: number;
  idDelete: number;

  constructor(private productService: ProductService, private tokenStorageService: TokenStorageService,
              private cartDetail: CardService,
              ) {
  }

  ngOnInit(): void {
    this.findUserName();
    this.findBuy();
  }

  findBuy() {
    this.cartDetail.findBuy(this.nameUser).subscribe(param => {
      this.products = param;
      console.log(this.products);
      this.items = this.products.length;
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
  confirm(idDetail: number, name: string) {
    this.idDelete = idDetail;
    this.name = name;
  }

  deleteCartDetail() {
    this.cartDetail.deleteCartDetail(this.idDelete).subscribe(() => {
      Swal.fire({
        text: 'Xóa thành công',
        icon: 'success',
        showConfirmButton: false,
        timer: 1500
      });
      this.ngOnInit();
    }, error => {
      Swal.fire({
        text: 'Xóa thất bại',
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
    });
  }
}
