import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFoodOrderComponent } from './add-food-order/add-food-order.component';
import { AddFoodProductComponent } from './add-food-product/add-food-product.component';
import { EditMenuComponent } from './edit-menu/edit-menu.component';
import { MenuComponent } from './menu/menu.component';
import { StaffMenuComponent } from './staff-menu/staff-menu.component';

const routes: Routes = [
  {path:"menu", component:MenuComponent},
  {path:"edit-menu/:id", component:EditMenuComponent},
  {path:"staff-menu/:id", component:StaffMenuComponent},
  {path:"add-foodProduct", component:AddFoodProductComponent},
  {path:"add-foodOrder", component:AddFoodOrderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
