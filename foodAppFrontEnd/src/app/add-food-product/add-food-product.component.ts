import { Component, OnInit } from '@angular/core';
import { MenuServiceService } from '../Services/menu-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-food-product',
  templateUrl: './add-food-product.component.html',
  styleUrls: ['./add-food-product.component.css']
})
export class AddFoodProductComponent implements OnInit {

  body:any;
  constructor(private menuService:MenuServiceService) { }

  ngOnInit(): void {
  }

  addProduct(detail:NgForm){
    console.log(detail.value);
    this.body = {
      name: detail.value.name,
      type: detail.value.type,
      price: detail.value.price,
      about: detail.value.about,
      availability: detail.value.availability,
      menu: {
        id : 1
      }
    }
    this.menuService.addFoodProduct(this.body).subscribe((data)=>{
      console.log(data);
      
    })
  }

}
