import {Role} from './role.model';

export class User {
  id?: number;
  username?: string;
  password?: string;
  enabled?: boolean;
  created_at?: string;
  updated_at?: string;
  roles?: Role[];
}
