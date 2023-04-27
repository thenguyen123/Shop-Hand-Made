import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AdminGuard} from './security-authentication/security-auth/admin.guard';
import {UserGuard} from './security-authentication/security-auth/user.guard';
import {ListComponent} from './component/product/list/list.component';


const routes: Routes = [
  {
    path: 'product',
    loadChildren: () => import('./component/product/product.module').then(module => module.ProductModule)
  },
  {
    path: 'security',
    loadChildren: () => import('./security-authentication/security-authentication.module')
      .then(module => module.SecurityAuthenticationModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
