import { Component, OnInit } from '@angular/core';
import { DataGatewayService } from '../services/data-gateway.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  userFullname:string | undefined;
  userRole:string | undefined;

  constructor(private service: DataGatewayService){
    this.userFullname = service.userFullName;
    this.userRole = service.userRole;
  }
  ngOnInit(): void {
    
  }

  isLoggedIn():boolean {
    return this.service.isLoggedIn;
  }

  

}
