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
  userId:any;
  constructor(private userService:UserService, private router: Router) { }

  ngOnInit(): void {
  }

  loginUser(form:NgForm){
    this.userService.login(form.value).subscribe((res)=>{
      console.log(res);
      this.userData = res;
      if(this.userData.statusCode == 302){
      this.userRole = this.userData.data.role;
      this.userId =this.userData.data.id;
      // console.log(this.userRole);
      localStorage.setItem('userRole',this.userRole);
      localStorage.setItem('userId',this.userId);
      if(this.userRole == "staff"){
        this.router.navigate(["add-foodOrder"]);
      }
      else{
        this.router.navigate(["menu"]);
      }

      window.alert("Login Successfull!");
    }
    else{
      window.alert("Invalid Credentials!")
    }
    })
  }

}
