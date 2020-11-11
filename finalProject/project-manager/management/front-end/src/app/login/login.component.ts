import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth.service';
import {User} from '../models/User';
import {Router} from '@angular/router';
import {EmployeePermision} from '../urlPermissions/EmployeePermision';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isAuthenticated = false;
  user = new User();
  errorMessage: string;

  constructor(private authenticationService: AuthService, private router: Router) {
  }

  ngOnInit() {
  }

  logIn() {
    this.authenticationService.logIn(this.user).subscribe(
      response => {
        this.router.navigate(['/homeComponent']);
      }
    );

  }


}
