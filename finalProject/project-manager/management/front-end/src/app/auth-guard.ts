// import {Injectable} from '@angular/core';
// import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
// import {AuthService} from "./auth.service";
//
// @Injectable()
// export class AuthGuard implements CanActivate {
//   constructor(private authService: AuthService, private router: Router) {
//   }
//
//   canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
//     // let url: string = state.url;
//
//     return this.checkLogin(url);
//   }
//
//   checkLogin(url: string): boolean {
//     console.log('check login', url);
//     if (this.authService.isAuthenticated) {
//       return true;
//     }
//
//     // Store the attempted URL for redirecting
//     this.authService.redirectUrl = url;
//
//     return false;
//   }
// }
