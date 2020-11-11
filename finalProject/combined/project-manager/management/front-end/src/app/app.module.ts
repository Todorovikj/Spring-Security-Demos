import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {HttpClientModule} from '@angular/common/http';
import {AuthService} from './auth.service';
import {ProjectsComponent} from './projects/projects.component';
import {RegisterComponent} from './register/register.component';
import {EmployeeProfileComponent} from './employee-profile/employee-profile.component';
import {FormsModule} from '@angular/forms';
import {LoggedInPermission} from './urlPermissions/LoggedInPermission';
import {EmployeePermision} from './urlPermissions/EmployeePermision';
import {ManagerPermissions} from './urlPermissions/MenagerPermission';
import {ManagerProfileComponent} from './manager-profile/manager-profile.component';
import {HomeComponent} from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProjectsComponent,
    RegisterComponent,
    EmployeeProfileComponent,
    ManagerProfileComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [

    AuthService,
    LoggedInPermission,
    EmployeePermision,
    ManagerPermissions],
  bootstrap: [AppComponent],
})
export class AppModule {
}
