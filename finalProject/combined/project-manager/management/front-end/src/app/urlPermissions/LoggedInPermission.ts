import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

@Injectable()
export class LoggedInPermission implements CanActivate {

  constructor(private router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (localStorage.getItem('currentUser')) {
      // logged in so return true
      return true;
    } else {
      this.router.navigate(['/login'], {queryParams: {returnUrl: state.url}});
      return false;
    }

  }
}
