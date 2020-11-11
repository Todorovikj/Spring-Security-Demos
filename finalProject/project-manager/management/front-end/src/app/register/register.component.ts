import {Component, OnInit} from '@angular/core';
import {User} from '../models/User';
import {Router} from '@angular/router';
import {AccountService} from '../account.service';
import {UserRole} from '../models/UserRole';
import {error} from '@angular/compiler/src/util';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user = new User();
  errorMessage: string;
  userRoles: UserRole[];


  constructor(public accountService: AccountService, public router: Router) {
  }

  ngOnInit() {
    this.accountService.getAllRoles()
      .subscribe(data => {
        console.log(data);
        this.userRoles = data;
      }, err => {
        console.log('error occured', err);
      });
  }

  register() {
    console.log(this.user);
    this.accountService.createAccount(this.user).subscribe(data => {
        this.router.navigate(['/login']);
      }, err => {
        console.log(err);
        // TODO DISPLAY DIFFERENT MESSAGES FOR DIFFERENT ERRORS
        this.errorMessage = 'username already exist';
      }
    );


  }

}
