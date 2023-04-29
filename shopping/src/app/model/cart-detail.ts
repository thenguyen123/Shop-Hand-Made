import {Cart} from './cart';
import {Product} from './product';

export interface CartDetail {
  amount: number;
  cart: Cart;
  product: Product;

}
