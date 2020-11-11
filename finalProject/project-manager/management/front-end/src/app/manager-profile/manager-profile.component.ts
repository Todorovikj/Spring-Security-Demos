import {Component, OnInit} from '@angular/core';
import {User} from '../models/User';
import {AuthService} from '../auth.service';
import {Router} from '@angular/router';
import {Project} from '../models/Project';
import {ApiService} from '../api.service';

@Component({
  selector: 'app-menager-profile',
  templateUrl: './manager-profile.component.html',
  styleUrls: ['./manager-profile.component.css']
})
export class ManagerProfileComponent implements OnInit {

  private currentUser: User;
  private projects: Project[];
  private project = new Project();

  constructor(private authService: AuthService, private router: Router, private apiService: ApiService) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }


  ngOnInit() {
    this.apiService.getProjects()
      .subscribe(response => {
        this.projects = response;
      });
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


  createProject() {
    this.apiService.createProject(this.project)
      .subscribe(response => {
        console.log(response);
        this.projects.push(response);
      });
  }


}
