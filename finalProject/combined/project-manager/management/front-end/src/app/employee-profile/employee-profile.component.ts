import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from '../models/User';
import { Router } from '@angular/router';
import { Task } from '../models/Task';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {

  currentUser: User;
  tasks: Task[];
  constructor(private authService: AuthService, private router: Router,private service: ApiService) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.service.getTasksForEmployee(this.currentUser.userId).subscribe(response=>this.tasks=response);
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
