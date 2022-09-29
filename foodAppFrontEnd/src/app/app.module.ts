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

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    MenuFilterPipe,
    EditMenuComponent,
    StaffMenuComponent,
    AddFoodProductComponent,
    AddFoodOrderComponent
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
