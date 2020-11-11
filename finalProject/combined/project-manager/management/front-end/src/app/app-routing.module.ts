import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {EmployeeProfileComponent} from './employee-profile/employee-profile.component';
import {LoggedInPermission} from './urlPermissions/LoggedInPermission';
import {EmployeePermision} from './urlPermissions/EmployeePermision';
import {ManagerPermissions} from './urlPermissions/MenagerPermission';
import {ManagerProfileComponent} from './manager-profile/manager-profile.component';
import {HomeComponent} from './home/home.component';
import {ProjectsComponent} from './projects/projects.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home', component: HomeComponent,canActivate: [LoggedInPermission]},
  {path: 'managerProfile', component: ManagerProfileComponent,canActivate: [LoggedInPermission,ManagerPermissions]},
  {path: 'employeeProfile', component: EmployeeProfileComponent, canActivate: [LoggedInPermission,EmployeePermision]},
  {path: 'project/:id', component: ProjectsComponent,canActivate: [LoggedInPermission,ManagerPermissions]},
  // otherwise redirect to profile
  {path: '**', redirectTo: '/employeeProfile'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {


}
