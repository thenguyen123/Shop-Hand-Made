import {Image} from './image';
import {Types} from './types';

export interface Product {
  id?: number;
  name?: string;
  prices?: number;
  description?: string;
  dateSubmitted?: string;
  img?: Image[];
  types?: Types;
  amount?: number;
  idCart?: number;
}

