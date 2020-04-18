import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { FoodsComponent } from './foods/foods.component';
import { HttpClientModule } from '@angular/common/http';
import { AddFoodComponent } from './add-food/add-food.component';
import { DrinksComponent } from './drinks/drinks.component';
import { AddDrinkComponent } from './add-drink/add-drink.component';
import { UpdateDrinksComponent } from './update-drinks/update-drinks.component';
import { UpdateFoodsComponent } from './update-foods/update-foods.component';

@NgModule({
  declarations: [
    AppComponent,
    FoodsComponent,
    AddFoodComponent,
    DrinksComponent,
    AddDrinkComponent,
    UpdateDrinksComponent,
    UpdateFoodsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
