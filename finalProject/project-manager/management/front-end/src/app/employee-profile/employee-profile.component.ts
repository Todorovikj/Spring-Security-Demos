import {Component, OnInit} from '@angular/core';
import {AuthService} from '../auth.service';
import {User} from '../models/User';
import {Router} from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {

  currentUser: User;

  constructor(public authService: AuthService, public router: Router) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
  }


  logOut() {
    this.authService.logOut()
      .subscribe(
        data => {
          localStorage.removeItem('currentUser');
          this.router.navigate(['/login']);
        },
        error => {

        });
  }

}
