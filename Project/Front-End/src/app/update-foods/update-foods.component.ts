import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Foods } from '../foods/foods.model';

@Component({
  selector: 'app-update-foods',
  templateUrl: './update-foods.component.html',
  styleUrls: ['./update-foods.component.css']
})
export class UpdateFoodsComponent implements OnInit {

  constructor() { }

  food: Foods = {};
  foodName: string;
  foodId: number;
  foodPrice: number;
  expiryDate: string;
  manifactureName: string;
  @Output() updateFood = new EventEmitter<Foods>();
  
  ngOnInit(): void {
  }

  update() {
    console.log(this.food);
    this.updateFood.emit(this.food);
  }

}
