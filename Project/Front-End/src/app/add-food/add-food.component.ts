import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Foods } from '../foods/foods.model';


@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.component.html',
  styleUrls: ['./add-food.component.css']
})
export class AddFoodComponent implements OnInit {

  food: Foods = {};
  foodName: string;
  foodPrice: number;
  expiryDate: string;
  manifactureName: string;
  @Output() addFood = new EventEmitter<Foods>();

  constructor() { }

  ngOnInit(): void {
  }

  add() {
    console.log(this.food);
    this.addFood.emit(this.food);
  }

}
