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
  size = 8;
  pageCount = 0;
  searchName = '';
  idTypes = 0;
  flag = true;

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

  more() {
    this.size += 4;
    this.findAll();
  }

  next() {
    this.page++;
    this.findAll();
  }
}
