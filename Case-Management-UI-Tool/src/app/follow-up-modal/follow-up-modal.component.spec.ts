import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FollowUpModalComponent } from './follow-up-modal.component';

describe('FollowUpModalComponent', () => {
  let component: FollowUpModalComponent;
  let fixture: ComponentFixture<FollowUpModalComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FollowUpModalComponent]
    });
    fixture = TestBed.createComponent(FollowUpModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
