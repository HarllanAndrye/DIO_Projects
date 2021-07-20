import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from '../../model/room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  id: number;
  room: Room;

  constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private roomService: RoomService) { }

  ngOnInit() {
    this.room = new Room();

    this.id = this.route.snapshot.params['id'];

    this.roomService.getRoom(this.id)
      .subscribe(data => {
        console.log(data)
        this.room = data;
      }, error => console.log(error));
  }

  list() {
    this.router.navigate(['rooms']);
  }

}
