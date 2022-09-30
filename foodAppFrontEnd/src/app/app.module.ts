import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import {HttpClientModule} from '@angular/common/http';
import { MenuFilterPipe } from './Pipes/menu-filter.pipe';
import { EditMenuComponent } from './edit-menu/edit-menu.component';
import { FormsModule } from '@angular/forms';
import { StaffMenuComponent } from './staff-menu/staff-menu.component';
import { AddFoodProductComponent } from './add-food-product/add-food-product.component';
import { AddFoodOrderComponent } from './add-food-order/add-food-order.component';
import { StaffDetailComponent } from './staff-detail/staff-detail.component';
import { StaffUpdateComponent } from './staff-update/staff-update.component';
import { StaffCreateComponent } from './staff-create/staff-create.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    MenuFilterPipe,
    EditMenuComponent,
    StaffMenuComponent,
    AddFoodProductComponent,
    AddFoodOrderComponent,
    StaffDetailComponent,
    StaffUpdateComponent,
    StaffCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
