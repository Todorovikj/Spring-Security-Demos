import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Project } from '../models/Project';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { map, switchMap } from 'rxjs/operators';
import { User } from '../models/User';
import { WorksOn } from '../models/WorksOn';
import { Task } from '../models/Task'
@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {

  private project = new Project();
  private employees: User[];
  private worksOn = new WorksOn();
  private employeesOnProject: User[];
  private task = new Task();
  private tasks: Task[];
  constructor(private service: ApiService, private route: ActivatedRoute, private location: Location) {
  }


  ngOnInit() {
    this.route.paramMap.pipe(
      map(it => +it.get('id')),
      switchMap(it => this.service.getProjectById(it))
    )
      .subscribe(response => {
        this.project = response;
        this.worksOn.projectId = this.project.projectId;
        this.task.projectId = this.project.projectId;
        this.getEmployeesOnProject();
        this.getTasks();
      });
  }

  getAllEmployees() {
    this.service.getAllEmployees().subscribe(response =>
      this.employees = response
    );
  }

  addEmployee() {
    this.service.addEmployeeToProject(this.worksOn).subscribe(
      response => this.getEmployeesOnProject()
    );
  }

  getEmployeesOnProject() {
    this.service.getEmployeesOnProject(this.project.projectId)
      .subscribe(
        response => {
          this.employeesOnProject = response;
          console.log(response);
        }
      );
  }

  createTask() {
    this.service.createTask(this.task).subscribe(response=>this.tasks.push(response));
  }
  getTasks(){
    this.service.getTasksForProject(this.project.projectId).subscribe(response=>this.tasks=response);
  }
}
