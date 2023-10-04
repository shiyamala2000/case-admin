import { Component } from '@angular/core';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';


@Component({
  selector: 'app-follow-up-modal',
  templateUrl: './follow-up-modal.component.html',
  styleUrls: ['./follow-up-modal.component.css']
})
export class FollowUpModalComponent {
  constructor(public modalRef: MdbModalRef<FollowUpModalComponent>) {}

  showTextArea: boolean = false;

  toggleTextArea() {
    this.showTextArea = !this.showTextArea;
  }
}
