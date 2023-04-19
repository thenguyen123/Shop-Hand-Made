import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {Product} from '../../../model/product';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  products: Product [];
  page = 0;
  size = 2;
pageCount = 0;
  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.productService.findAll(this.page, this.size).subscribe(param => {
      this.products = param.content;
      this.pageCount = param.totalPage;
    });
  }
}
