import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Room } from '../../model/room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  rooms: Observable<Room[]>;

  constructor(
    private roomService: RoomService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.rooms = this.roomService.getRoomsList();
  }

  deleteRoom(id: number) {
    this.roomService.deleteRoom(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  roomDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateRoom(id: number){
    this.router.navigate(['update', id]);
  }

}
