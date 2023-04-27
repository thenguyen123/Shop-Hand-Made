import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './list/list.component';
import {DetailComponent} from './detail/detail.component';
import {AdminGuard} from '../../security-authentication/security-auth/admin.guard';
import {UserGuard} from '../../security-authentication/security-auth/user.guard';
import {CardComponent} from './card/card.component';


const routes: Routes = [
  {path: 'list/:name/:id', component: ListComponent },
  {path: 'detail/:id', component: DetailComponent },
  {path: 'card', component: CardComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
