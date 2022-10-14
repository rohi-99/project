import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MenuServiceService } from '../Services/menu-service.service';
import { OrderServiceService } from '../Services/order-service.service';

@Component({
  selector: 'app-staff-menu',
  templateUrl: './staff-menu.component.html',
  styleUrls: ['./staff-menu.component.css']
})
export class StaffMenuComponent implements OnInit {
  staffMenuData:any;
  body:any=null;
  foodOrderId:any;
  foodProductData:any;
  foodOrder:any;
  foodOrderBody:any;
  itemResponse:any;
  billDetail:any;
  // temp:any=1;
  constructor(private router: Router, private menuService:MenuServiceService, private route: ActivatedRoute, private orderService:OrderServiceService) { }

  ngOnInit(): void {
    this.menuService.getMenu().subscribe((res)=>{
      console.log(res);
      this.staffMenuData = res;
      // console.log("staffMenuData----",this.staffMenuData);

      this.foodOrderId = this.route.snapshot.params['id'];
    })
  }

  addItem(foodProductId:any,quantity:any){
    // console.log(foodProductId);
    // console.log(quantity.value);
    if(quantity.value != 0){
    this.menuService.getFoodProductId(foodProductId).subscribe((res)=>{
      
      this.foodProductData=res;
      console.log("foodProductData",this.foodProductData);
      // this.body = JSON.stringify(this.foodProductData.data);
      // localStorage.setItem('body',this.body);
      this.body = {
        name: this.foodProductData.data.name,
        type: this.foodProductData.data.type,
        price: this.foodProductData.data.price,
        quantity: quantity.value,
        foodorder: {
          id : this.foodOrderId
        } 
    }
    this.orderService.saveItem(this.body).subscribe((res)=>{
      console.log(res);
      this.itemResponse=res;
      // localStorage.setItem('Item Id '+this.temp,this.itemResponse.id);
      // this.temp++;
      
    })
    
    
  })
    }
    else{
      window.alert("Please enter quantity.")
    }
  }

  updateOrder(){
    this.orderService.getFoodOrderById(this.foodOrderId).subscribe((res)=>{
      console.log(res);
      this.foodOrder=res;

      let currentTime = new Date();
      let orderTime = currentTime.toLocaleTimeString();

      let expectedTime = new Date(currentTime.getTime() + 30*60000);
      let deliveryTime = expectedTime.toLocaleTimeString();
      let totalPrice = this.calculatePrice(this.foodOrder);
      let totalAmount = (totalPrice + totalPrice*0.05);

      this.foodOrderBody ={
        status: "Preparing",
        totalPrice: totalPrice,
        grandTotal:totalAmount,
        orderCreatedTime: orderTime,
        orderDeliveryTime: deliveryTime,
        customerName: this.foodOrder.customerName,
        contactNumber: this.foodOrder.contactNumber,
        email: this.foodOrder.email,
        user:{
          id: localStorage.getItem("userId")
        }
      }


      this.orderService.updateFoodOrder(this.foodOrderId,this.foodOrderBody).subscribe((res)=>{
        console.log(res);
        
        this.orderService.getFoodOrderById(this.foodOrderId).subscribe((response)=>{
          this.billDetail=response;
          this.orderService.sendEmail(this.billDetail).subscribe((emailResponse)=>{
            console.log(emailResponse);

            window.alert("Ordered Successfully!");
            this.router.navigate(["add-foodOrder"]);
            
          })
        })
      })

      

      



    })
  }

  // removeItem(){



  //   this.orderService.deleteItem(id).subscribe((res)=>{
  //     console.log(res);
      
  //   })
  // }

  calculatePrice(data:any):number{
    let total:number=0;
    for(let i of data.item){
      total = total+(i.price)*(i.quantity);
    }

    return total;
  }
}
