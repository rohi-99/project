import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MenuServiceService {

  constructor(private http:HttpClient) { }

  getMenu(){
    return this.http.get("http://localhost:8080/findallmenu");
  }

  updateMenu(id:any, body:any){
    return this.http.put(`http://localhost:8080/foodProduct/${id}`,body);
  }

  deleteMenuData(id:any){
    return this.http.delete(`http://localhost:8080/deletefoodProducts/${id}`);
  }
  addFoodProduct(body:any){
    return this.http.post("http://localhost:8080/savefoodProducts",body);
  }

  getFoodProductId(id:any){
    return this.http.get(`http://localhost:8080/getFoodProductById/${id}`);
  }

}
