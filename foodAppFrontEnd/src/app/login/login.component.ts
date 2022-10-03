import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userData:any;
  userRole:any;
  constructor(private userService:UserService, private router: Router) { }

  ngOnInit(): void {
  }

  loginUser(form:NgForm){
    this.userService.login(form.value).subscribe((res)=>{
      console.log(res);
      this.userData = res;
      this.userRole = this.userData.data.role;
      // console.log(this.userRole);
      localStorage.setItem('userRole',this.userRole);
      if(this.userRole == "staff"){
        this.router.navigate(["add-foodOrder"]);
      }
      else{
        this.router.navigate(["menu"]);
      }

      window.alert("Login Successfull!");
    })
  }

}
