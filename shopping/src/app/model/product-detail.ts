import {Image} from './image';
import {Product} from './product';

export interface ProductDetail {
  product?: Product;
  imageList?: Image[];
}
