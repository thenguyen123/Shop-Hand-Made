import {Cart} from './cart';
import {Product} from './product';

export interface AddCart {
  id: number;
  amount: number;
  cart: Cart;
  product: Product;
}
