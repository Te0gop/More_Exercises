import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css']
})
export class FoodsComponent implements OnInit {
  @Input() foodId: number;
  @Input() foodName: string;
  @Input() foodPrice: number;
  @Input() expiryDate: string;
  @Input() manifactureName: string;
  @Output() deleteEvent = new EventEmitter<number>();

  constructor() { }

  ngOnInit(): void {
  }

  deleteFood() {
    this.deleteEvent.emit(this.foodId);
  }

}
