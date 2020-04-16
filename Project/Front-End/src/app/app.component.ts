import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Foods } from './foods/foods.model';
import { Drinks } from './drinks/drinks.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Shop-ProjectTask';
  
  addFood: boolean = false;
  addDrink: boolean = false;
  updateDrink: boolean = false;
  updateFood: boolean = false;

  public foods: Foods[] = []; 
  public drinks: Drinks[] = [];

  constructor(private http : HttpClient) {

  }

  searchFoods() {
    this.http.get<Foods[]>('/foods').subscribe((body) => {
      console.log("Body is " + body); 
      console.log(body);
      this.foods = body;
      console.log(this.foods);
    });
  }

  deleteFood(id: number) {
    console.log("Delete food with id = " + id)
    this.http.delete("foods/" + id).subscribe(() => {
      console.log("food deleted.")
    this.searchFoods();
    });
  }

  showAddFood() {
    this.addFood = true;
  }

  addNewFood(food: Foods) {
    this.http.post<Foods>("foods", food).subscribe((body) => {
      this.addFood = false;
      this.searchFoods();
    })
  }

  searchDrinks() {
    this.http.get<Drinks[]>('/drinks').subscribe((body) => {
      console.log("Body is " + body); 
      console.log(body);
      this.drinks = body;
      console.log(this.drinks);
    });
  }

  deleteDrink(id: number) {
    console.log("Delete drink with id = " + id)
    this.http.delete("drinks/" + id).subscribe(() => {
      console.log("drink deleted.")
    this.searchDrinks();
    });
  }

  showAddDrink() {
    this.addDrink = true;
  }

  addNewDrink(drink: Drinks) {
    this.http.post<Drinks>("drinks", drink).subscribe((body) => {
      this.addDrink = false;
      this.searchDrinks();
    });
  }

  showUpdateDrink() {
    this.updateDrink = true;
  }

  updateNewDrink(drink: Drinks) {
    this.http.put<Drinks>("drinks", drink).subscribe((body) => {
      this.updateDrink = false;
      this.searchDrinks();
    });
  }

  showUpdateFood() {
    this.updateFood = true;
  }

  updateNewFood(food: Foods) {
    this.http.put<Foods>("foods", food).subscribe((body) => {
      this.updateFood = false;
      this.searchFoods();
    });
  }

  
}
