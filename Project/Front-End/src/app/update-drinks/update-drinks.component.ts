import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Drinks } from '../drinks/drinks.model';

@Component({
  selector: 'app-update-drinks',
  templateUrl: './update-drinks.component.html',
  styleUrls: ['./update-drinks.component.css']
})
export class UpdateDrinksComponent implements OnInit {

  constructor() { }

  drink: Drinks = {};
  drinkName: string;
  drinkId: number;
  drinkPrice: number;
  alcoholContent: number;
  manifactureName: string;
  @Output() updateDrink = new EventEmitter<Drinks>();
  
  ngOnInit(): void {
  }

  update() {
    console.log(this.drink);
    this.updateDrink.emit(this.drink);
  }

}
