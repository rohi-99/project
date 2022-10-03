import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  getAllStaff(){
    return this.http.get("http://localhost:8080/findalluser");
  }

  updateUser(id:any,body:any){
    return this.http.put(`http://localhost:8080/user/${id}`,body);
  }

  addUser(body:any){
    return this.http.post("http://localhost:8080/saveuser",body);
  }

  login(body:any){
    return this.http.post("http://localhost:8080/login",body);
  }

  deleteUser(id:any){
   return this.http.delete(`http://localhost:8080/deleteUser/${id}`); 
  }
}
