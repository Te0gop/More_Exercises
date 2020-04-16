import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Drinks } from '../drinks/drinks.model';

@Component({
  selector: 'app-add-drink',
  templateUrl: './add-drink.component.html',
  styleUrls: ['./add-drink.component.css']
})
export class AddDrinkComponent implements OnInit {

  drink: Drinks = {};
  drinkName: string;
  drinkPrice: number;
  alcoholContent: number;
  manifactureName: string;
  @Output() addDrink = new EventEmitter<Drinks>();

  constructor() { }

  ngOnInit(): void {
  }

  add() {
    console.log(this.drink);
    this.addDrink.emit(this.drink);
  }
}
