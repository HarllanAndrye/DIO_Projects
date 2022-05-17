import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Book } from "./model/books.model";

export const books: Book[] = [
  { id: '1', name: 'Book1', price: 10, quantity: 1, category: "Acao", img: "img1" },
  { id: '2', name: 'Book2', price: 10, quantity: 1, category: "Acao", img: "img2" },
  { id: '3', name: 'Book3', price: 10, quantity: 1, category: "Acao", img: "img3" },
];

@Injectable()
export class BooksService {

  // private url = 'https://some-url-api/books';  // URL to web api

  constructor(private http: HttpClient) { }

  getBooks(): Observable<Book[]> {
    return of(books); // MOCK
  }

  // getBooks(): Observable<Book[]> {
  //   return this.http.get(this.url)
  // }

}
