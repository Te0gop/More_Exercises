import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-drinks',
  templateUrl: './drinks.component.html',
  styleUrls: ['./drinks.component.css']
})
export class DrinksComponent implements OnInit {
  @Input() drinkId: number;
  @Input() drinkName: string;
  @Input() drinkPrice: number;
  @Input() manifactureName: string;
  @Input() alcoholContent: number;
  @Output() deleteEvent = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  deleteDrink() {
    this.deleteEvent.emit(this.drinkId);
  }

}
