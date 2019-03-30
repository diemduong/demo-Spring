import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../book";
import {BookService} from "../book.service";
import {BooksListComponent} from "../books-list/books-list.component";

@Component({
  selector: 'book-datas',
  templateUrl: './book-datas.component.html',
  styleUrls: ['./book-datas.component.css']
})
export class BookDatasComponent implements OnInit {

  @Input() book: Book;

  constructor(private bookService: BookService, private listComponent: BooksListComponent) {
  }

  ngOnInit() {
  }

  updateActive(isActive: boolean) {
    this.bookService.updateBook(this.book.id, {
      book_name: this.book.book_name,
      type: this.book.type,
      progress: this.book.progress
    }).subscribe(data => {
        console.log(data);
        this.book = data as Book;
      },
      error => console.log(error));
  }

  deleteBook() {
    this.bookService.deleteBook(this.book.id).subscribe(data => {
        console.log(data);
        this.listComponent.reloadData();
      },
      error => console.log(error));
  }
}
