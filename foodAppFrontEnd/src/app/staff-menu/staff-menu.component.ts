import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MenuServiceService } from '../Services/menu-service.service';
import { OrderServiceService } from '../Services/order-service.service';

@Component({
  selector: 'app-staff-menu',
  templateUrl: './staff-menu.component.html',
  styleUrls: ['./staff-menu.component.css']
})
export class StaffMenuComponent implements OnInit {
  staffMenuData:any;
  body:any;
  foodOrderId:any;
  foodProductData:any;
  constructor(private menuService:MenuServiceService, private route: ActivatedRoute, private orderService:OrderServiceService) { }

  ngOnInit(): void {
    this.menuService.getMenu().subscribe((res)=>{
      console.log(res);
      this.staffMenuData = res;
      console.log(this.staffMenuData[0].foodProducts);

      this.foodOrderId = this.route.snapshot.params['id'];
    })
  }

  addItem(foodProductId:any,quantity:any){
    // console.log(foodProductId);
    // console.log(quantity.value);
    
    this.menuService.getFoodProductId(foodProductId).subscribe((res)=>{
      this.foodProductData=res;
      // console.log("foodProductData",this.foodProductData);
      
    })
    
    this.body = {
      name: this.foodProductData.name,
      type: this.foodProductData.type,
      price: this.foodProductData.price,
      quantity: quantity.value,
      foodorder: {
        id : this.foodOrderId
      } 
  }

  this.orderService.saveItem(this.body).subscribe((res)=>{
    console.log(res);
    
  })

  }
}
