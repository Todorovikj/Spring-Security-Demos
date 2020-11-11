import {Injectable} from '@angular/core';
import {User} from './models/User';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserRole} from './models/UserRole';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private http: HttpClient) {
  }


  createAccount(user: User) {
    return this.http.post('/api/account/register', user);
  }

  getAllRoles() : Observable<UserRole[]> {
    return this.http.get<UserRole[]>('/api/account/roles');
  }

}
