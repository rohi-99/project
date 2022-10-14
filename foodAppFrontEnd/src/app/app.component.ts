import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'foodAppFrontEnd';

  constructor(private router:Router){}

  logout(){
    localStorage.removeItem('userRole');
    localStorage.removeItem('userId');
    this.router.navigate(['login']);
    window.alert("Logout Successfull!");

  }
}
