import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuServiceService } from '../Services/menu-service.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  menuData:any;
  constructor(private menuService:MenuServiceService, private router:Router) { }

  ngOnInit(): void {

    this.menuService.getMenu().subscribe((res)=>{
      console.log(res);
      this.menuData = res;
      // console.log("menuData----",this.menuData);
      
    })
  }

  deleteProduct(id:any){
    this.menuService.deleteMenuData(id).subscribe((response)=>{
      console.log(response);
     this.router.navigate(['menu']);
     this.menuService.getMenu().subscribe((data)=>{
      this.menuData = data;
      console.log("menudata",this.menuData);
      
     })
    })
  }

}
