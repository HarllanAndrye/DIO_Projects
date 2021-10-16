import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrls: ['./contato.component.css']
})
export class ContatoComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  enviarContato() {
    Swal.fire(
      'Informação!',
      'Funcionalidade indisponível no momento.',
      'info'
    )
  }

}
