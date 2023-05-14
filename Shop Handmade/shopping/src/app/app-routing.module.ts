import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ErrorComponent} from './component/error/error.component';
import {BodyComponent} from './component/body/body.component';
import {InformationUserComponent} from './component/information-user/information-user.component';
import {UserGuard} from './security-authentication/security-auth/user.guard';


const routes: Routes = [
  {
    path: 'product',
    loadChildren: () => import('./component/product/product.module').then(module => module.ProductModule)
  },
  {
    path: 'security',
    loadChildren: () => import('./security-authentication/security-authentication.module')
      .then(module => module.SecurityAuthenticationModule)
  },
  {path: 'user', component: InformationUserComponent , canActivate: [UserGuard] },
  {
    path: '', component: BodyComponent
  },
  {
    path: '**', component: ErrorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
