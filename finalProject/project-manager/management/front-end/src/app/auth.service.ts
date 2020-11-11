import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {User} from './models/User';
import {LoginResponse} from './models/LoginResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // isAuthenticated = Observable.create();
  // user: Observable<User>;
  // redirectUrl: string;

  constructor(private http: HttpClient) {
  }

  // getUser(): Observable<Observable<User>> {
  //   //   if (this.user == null) {
  //   //     this.user = this.http.get('/api/user')
  //   //       .map(response => {
  //   //         this.isAuthenticated = true;
  //   //         return response
  //   //       })
  //   //   }
  //   //   return this.user;
  //   // }
  //
  //
  //   console.log(this.user);
  //   return this.http.get<Observable<User>>('/api/user');
  //
  // }

  public logIn(user: User) {
    const base64Credential: string = btoa(user.username + ':' + user.password);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Basic ${base64Credential}`
    });


    const options = {headers};
    return this.http.get('/api/account/login', options)
    // .subscribe(response=>{
    // })
    // pipe(
    //   map((response: Response) => {
    //     if (user) {
    //       // store user details  in local storage to keep user logged in between page refreshes
    //       localStorage.setItem('currentUser', JSON.stringify(user));
    //     }
    //   }));
      .pipe(
        map((response: LoginResponse) => {
          const loggedInUser = response.principal;
          if (loggedInUser) {
            localStorage.setItem('currentUser', JSON.stringify(loggedInUser));
            //console.log(localStorage.getItem('currentUser'));
          } else {
            console.log('BELJAA');
          }
        })
      );
  }

  logOut() {
    console.log('logout called');
    return this.http.post('/api/logout', {message: 'log me out'});

  }

  testLoggedInUser() {
    this.http.get('/api/test/1').subscribe(
      response => {
        console.log(response);
      }
    );
  }


}
