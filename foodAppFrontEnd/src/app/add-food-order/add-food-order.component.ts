import { Component, OnInit } from '@angular/core';
import { OrderServiceService } from '../Services/order-service.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-food-order',
  templateUrl: './add-food-order.component.html',
  styleUrls: ['./add-food-order.component.css']
})
export class AddFoodOrderComponent implements OnInit {
  result: any;
  constructor(private orderService: OrderServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  createFoodOrder(data: NgForm) {
    if (data.value.customerName && data.value.email && data.value.contactNumber) {
      this.orderService.addFoodOrder(data.value).subscribe((res) => {
        console.log(res);
        this.result = res;
        let id = this.result.id;

        this.router.navigate([`staff-menu/${id}`]);

      })
    }
    else {
      window.alert("Please enter the Details!")
    }
  }

}
