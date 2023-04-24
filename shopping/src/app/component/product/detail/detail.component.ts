import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../service/product.service';
import {ActivatedRoute} from '@angular/router';
import {Product} from '../../../model/product';
import {ProductDetail} from '../../../model/product-detail';
import {Image} from '../../../model/image';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  id: number;
  product: ProductDetail;
  imgProduct: Image[];

  constructor(private productService: ProductService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      this.id = +param.get('id');
    });
    this.findById();
  }

  findById() {
    this.productService.findById(this.id).subscribe(param => {
      this.product = param;
      this.imgProduct = this.product.imageList;
    });
  }
}
