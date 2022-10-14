import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-staff-detail',
  templateUrl: './staff-detail.component.html',
  styleUrls: ['./staff-detail.component.css']
})
export class StaffDetailComponent implements OnInit {
  result:any;
  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {

    this.userService.getAllStaff().subscribe((res)=>{
      console.log(res);
      this.result=res;
    })
  }

  deleteUser(id:any){
    if(window.confirm("Selected staff will be deleted! Continue?")){
    this.userService.deleteUser(id).subscribe((res)=>{
      console.log(res);
      this.router.navigate(['staff-detail']);
     this.userService.getAllStaff().subscribe((data)=>{
      this.result = data;
      window.alert("Deleted Successfully!");

     })
    })
  }
  }


}
