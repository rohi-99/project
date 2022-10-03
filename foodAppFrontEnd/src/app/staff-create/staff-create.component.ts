import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-staff-create',
  templateUrl: './staff-create.component.html',
  styleUrls: ['./staff-create.component.css']
})
export class StaffCreateComponent implements OnInit {
  body: any;
  constructor(private userService:UserService, private router: Router) { }

  ngOnInit(): void {
  }

  addUser(detail:NgForm){
    this.body = {
      name: detail.value.name,
      email: detail.value.email,
      password: detail.value.password,
      role: "staff"
    }
    this.userService.addUser(this.body).subscribe((res)=>{
      console.log(res);
      this.router.navigate(["staff-detail"]);
    })
  }
}
