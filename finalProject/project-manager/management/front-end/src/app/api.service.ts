import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Project} from './models/Project';
import {User} from './models/User';
import {WorksOn} from './models/WorksOn';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

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
}
