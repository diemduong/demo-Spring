import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = 'http://localhost:8080/bookControl/books';

  constructor(private http: HttpClient) { }

  getBook(id: number): Observable<Object> {
    return this.http.get('${this.baseUrl}/${id}');
  }

  createBook(book: Object): Observable<Object> {
    return this.http.post('${this.baseUrl}' + '/create', book);
  }

  updateBook(id: number, value: any): Observable<Object> {
    return this.http.delete('${this.baseUrl}/update/${id}', value);
  }

  deleteBook(id: number): Observable<any> {
    return this.http.delete('${this.baseUrl}/${id}', { responseType: 'text' });
  }

  getBookList(): Observable<any> {
    return this.http.get('${this.baseUrl}');
  }

  deleteAll(): Observable<any> {
    return this.http.delete('${this.baseUrl}' + '/delete', { responseType: 'text' });
  }
}
