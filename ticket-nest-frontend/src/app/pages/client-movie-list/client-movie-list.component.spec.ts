import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientMovieListComponent } from './client-movie-list.component';

describe('ClientMovieListComponent', () => {
  let component: ClientMovieListComponent;
  let fixture: ComponentFixture<ClientMovieListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClientMovieListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientMovieListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
