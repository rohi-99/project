import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderServiceService {

  constructor(private http:HttpClient) { }

  addFoodOrder(body:any){
    return this.http.post("http://localhost:8080/savefoodorder",body);
  }

  saveItem(body:any){
    return this.http.post("http://localhost:8080/saveitem",body);
  }

  getFoodOrderById(id:any){
    return this.http.get(`http://localhost:8080/getFoodOrderById/${id}`);
  }

  updateFoodOrder(id:any,body:any){
    return this.http.put(`http://localhost:8080/foodorder/${id}`,body);
  }

  deleteItem(id:any){
    return this.http.delete(`http://localhost:8080/deleteitem/${id}`);
  }

  sendEmail(body:any){
    return this.http.post("http://localhost:8080/sendMail",body);
  }
}
