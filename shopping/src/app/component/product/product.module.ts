import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import { ListComponent } from './list/list.component';
import { DetailComponent } from './detail/detail.component';
import { CardComponent } from './card/card.component';
import { AddCartComponent } from './add-cart/add-cart.component';
import { HistoryComponent } from './history/history.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [ListComponent, DetailComponent, CardComponent, AddCartComponent, HistoryComponent],
  imports: [
    CommonModule,
    ProductRoutingModule,
    FormsModule
  ]
})
export class ProductModule { }
