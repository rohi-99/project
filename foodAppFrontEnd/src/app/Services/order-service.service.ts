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
    console.log("body----------",body);
    
    return this.http.post("http://localhost:8080/saveitem",body);
  }
}
