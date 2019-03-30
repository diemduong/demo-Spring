import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {Book} from "../book";
import {BookService} from "../book.service";

@Component({
  selector: 'books-list',
  templateUrl: './books-list.component.html',
  styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {

  books: Observable<Book>;

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.reloadData();
  }

  deleteBooks() {
    this.bookService.deleteAll().subscribe(data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log('ERROR: ' + error));
  }

  reloadData() {
    this.books = this.bookService.getBookList();
  }
}
