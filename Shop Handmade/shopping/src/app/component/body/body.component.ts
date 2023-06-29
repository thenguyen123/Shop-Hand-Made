import { Component, OnInit } from '@angular/core';
import {Producdto} from '../../model/producdto';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {

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
        this.findAll();
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
