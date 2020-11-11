import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

@Injectable()
export class EmployeePermision implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const authority = JSON.parse(localStorage.getItem('currentUser'));
    if (authority.role.roleName === 'EMPLOYEE') {
      return true;
    } else {
      this.router.navigate(['/managerProfile']);
      return false;
    }

  }
}
