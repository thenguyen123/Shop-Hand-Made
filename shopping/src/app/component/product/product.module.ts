import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { ListComponent } from './list/list.component';
import { DetailComponent } from './detail/detail.component';
import { CardComponent } from './card/card.component';
import { AddCartComponent } from './add-cart/add-cart.component';


@NgModule({
  declarations: [ListComponent, DetailComponent, CardComponent, AddCartComponent],
  imports: [
    CommonModule,
    ProductRoutingModule
  ]
})
export class ProductModule { }
