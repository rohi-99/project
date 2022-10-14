import { Component, OnInit } from '@angular/core';
import { MenuServiceService } from '../Services/menu-service.service';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-menu',
  templateUrl: './edit-menu.component.html',
  styleUrls: ['./edit-menu.component.css']
})
export class EditMenuComponent implements OnInit {
  selectedProduct: any;
  result: any;
  body: any;
  constructor(private menuService: MenuServiceService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.menuService.getMenu().subscribe((data) => {
      this.result = data;
      console.log("Food products", this.result[0].foodProducts);


      for (let i of this.result[0].foodProducts) {
        if (i.id == id) {
          this.selectedProduct = i;
          console.log("selected Food product", this.selectedProduct);

        }
      }
    })
  }

  editProduct(detail: NgForm) {
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
    this.menuService.updateMenu(this.selectedProduct.id, this.body).subscribe((data) => {
      console.log(data);
      window.alert("Updated successfully!")
      this.router.navigate(["menu"]);
    })
  }
}
