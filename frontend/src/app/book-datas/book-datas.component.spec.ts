import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookDatasComponent } from './book-datas.component';

describe('BookDatasComponent', () => {
  let component: BookDatasComponent;
  let fixture: ComponentFixture<BookDatasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookDatasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookDatasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
