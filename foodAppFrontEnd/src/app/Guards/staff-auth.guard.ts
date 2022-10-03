import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StaffAuthGuard implements CanActivate {
  constructor(private router:Router){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot):boolean {
      if(localStorage.getItem('userRole') == 'staff' ){   
        return true;
      } 
      else{
        this.router.navigate(['login']);
        if(localStorage.getItem('userRole')){
        window.alert("Only Staff can access!");
        }
        else{
          window.alert("Please Login!");
        }
        return false;
      }
  }
  
}
