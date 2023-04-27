import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';
import {Producdto} from '../../../model/producdto';
import {TokenStorageService} from '../../../security-authentication/service/token-storage.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  products: Producdto [];
  page = 0;
  size = 5;
  pageCount = 0;
  searchName = '';
  idTypes = 0;

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      this.searchName = param.get('name');
      this.idTypes = +param.get('id');
      if (this.searchName === 'l1') {
        this.searchName = '';
        this.findAll();
      } else {
        this.findAll();
      }
    });
  }

  findAll() {
    this.productService.search(this.searchName, this.page, this.size, this.idTypes).subscribe(param => {
      this.products = param.content;
      this.pageCount = param.totalPages;
    });
  }

  next() {
    this.page++;
    this.findAll();
  }


  previous() {
    this.page--;
    this.findAll();
  }

  first() {
    this.page = 0;
    this.findAll();
  }

  last() {
    this.page = this.pageCount - 1;
    this.findAll();
  }
}
