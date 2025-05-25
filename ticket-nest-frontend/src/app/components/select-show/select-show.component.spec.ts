import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectShowComponent } from './select-show.component';

describe('SelectShowComponent', () => {
  let component: SelectShowComponent;
  let fixture: ComponentFixture<SelectShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SelectShowComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SelectShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
