import { Component, OnInit } from '@angular/core';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-staff-detail',
  templateUrl: './staff-detail.component.html',
  styleUrls: ['./staff-detail.component.css']
})
export class StaffDetailComponent implements OnInit {
  result:any;
  constructor(private userService:UserService) { }

  ngOnInit(): void {

    this.userService.getAllStaff().subscribe((res)=>{
      console.log(res);
      this.result=res;
    })
  }



}
