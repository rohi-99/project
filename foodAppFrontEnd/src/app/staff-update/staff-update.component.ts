import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../Services/user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-staff-update',
  templateUrl: './staff-update.component.html',
  styleUrls: ['./staff-update.component.css']
})
export class StaffUpdateComponent implements OnInit {
  result: any;
  selectedUser: any;
  body: any;
  id:any;
  constructor(private userService:UserService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.userService.getAllStaff().subscribe((data) => {
      this.result = data;
    
      for (let i of this.result) {
        if (i.id == this.id) {
          this.selectedUser = i;

        }
      }
    })
  }

  editUser(detail: NgForm) {
    this.body = {
      name: detail.value.name,
      email: detail.value.email,
      password: this.selectedUser.password,
      role: this.selectedUser.role,
    }
    this.userService.updateUser(this.id, this.body).subscribe((data) => {
      console.log(data);
      window.alert("Updated Successfully");
      this.router.navigate(["staff-detail"]);
    })
  }



}
