import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

@Injectable()
export class ManagerPermissions implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const authority = JSON.parse(localStorage.getItem('currentUser'));
    // console.log(authority.role.roleName);
    //console.log(authority);
    if (authority.role.roleName === 'MANAGER') {
      // logged in so return true
      return true;
    } else {
      this.router.navigate(['/employeeProfile']);
      return false;
    }

  }
}
