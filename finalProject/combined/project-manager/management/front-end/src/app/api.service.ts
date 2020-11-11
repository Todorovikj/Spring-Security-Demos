import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from './models/Project';
import { User } from './models/User';
import { WorksOn } from './models/WorksOn';
import { Task } from './models/Task';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  getTasksForEmployee(userId: number) {
    throw new Error("Method not implemented.");
  }

  project: Project;

  constructor(private http: HttpClient) {


  }

  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>('/api/projects');
  }

  createProject(project: Project): Observable<Project> {
    return this.http.post<Project>('/api/projects', project);
  }

  getProjectById(id: number): Observable<Project> {
    return this.http.get<Project>(`/api/projects/${id}`);
  }

  getAllEmployees(): Observable<User[]> {
    return this.http.get<User[]>(`/api/user/employees`);
  }

  addEmployeeToProject(worksOn: WorksOn): Observable<WorksOn> {
    return this.http.post<WorksOn>(`/api/projects/addEmployee`, worksOn);
  }

  getEmployeesOnProject(projectId: number): Observable<User[]> {
    return this.http.get<User[]>(`/api/projects/employeesOnProject/${projectId}`);
  }

  createTask(task: Task): Observable<Task> {
    return this.http.post<Task>('/api/tasks', task);
  }

  getTasksForProject(projectId: Number): Observable<Task[]> {
    return this.http.get<Task[]>(`/api/tasks/project/${projectId}`);
  }

  getTasksForEmployee(employeeId: Number): Observable<Task[]> {
    return this.http.get<Task[]>(`/api/tasks/employee/${employeeId}`);
  }
}
