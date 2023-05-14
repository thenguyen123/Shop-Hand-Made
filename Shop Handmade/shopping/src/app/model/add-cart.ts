import {Cart} from './cart';
import {Product} from './product';

export interface AddCart {
  amount: number;
  cart: Cart;
  product: Product;
}
