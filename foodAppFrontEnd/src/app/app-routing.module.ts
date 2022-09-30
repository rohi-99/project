import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddFoodOrderComponent } from './add-food-order/add-food-order.component';
import { AddFoodProductComponent } from './add-food-product/add-food-product.component';
import { EditMenuComponent } from './edit-menu/edit-menu.component';
import { MenuComponent } from './menu/menu.component';
import { StaffCreateComponent } from './staff-create/staff-create.component';
import { StaffDetailComponent } from './staff-detail/staff-detail.component';
import { StaffMenuComponent } from './staff-menu/staff-menu.component';
import { StaffUpdateComponent } from './staff-update/staff-update.component';

const routes: Routes = [
  {path:"menu", component:MenuComponent},
  {path:"edit-menu/:id", component:EditMenuComponent},
  {path:"staff-menu/:id", component:StaffMenuComponent},
  {path:"add-foodProduct", component:AddFoodProductComponent},
  {path:"add-foodOrder", component:AddFoodOrderComponent},
  {path:"staff-detail", component:StaffDetailComponent},
  {path:"staff-update/:id", component:StaffUpdateComponent},
  {path:"staff-create", component:StaffCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
