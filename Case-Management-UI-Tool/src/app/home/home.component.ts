import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSidenavModule } from '@angular/material/sidenav';
import { CaseManagementService } from '../case-management.service';
import { CaseManagement } from '../case-management';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { GenerateLetterDialogComponent } from '../generate-letter-dialog/generate-letter-dialog.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule, MatCheckboxModule, MatDatepickerModule, MatFormFieldModule, CommonModule, MatDialogModule, FormsModule]
})
export class HomeComponent implements OnInit {
  // @Output() idFound = new EventEmitter<number>();

  caseManagementVariable: CaseManagement[] = [];
  searchId: string = '';
  filteredData: CaseManagement[] = [];

  constructor(
    private caseManagementService: CaseManagementService,
    private router: Router,
    public dialog: MatDialog,

  ) { }

  ngOnInit(): void {
    this.getAllCaseManagementTableValues();
  }

  getAllCaseManagementTableValues(): void {
    this.caseManagementService.getAllTableValues().subscribe((caseManagementVariable: CaseManagement[]) => {
      console.log('Response for getAllTableValues==>', caseManagementVariable);
      this.caseManagementVariable = caseManagementVariable;
      console.log(' After Response for getAllTableValues==>', caseManagementVariable);
    });
  }

  searchById(): void {
    this.filteredData = this.caseManagementVariable.filter((caseItem) =>
      caseItem.id.toString() === this.searchId
    );
  }

  openGenerateLetterDialog() {
    const caseItem = this.caseManagementVariable.find((item) => item.id.toString() === this.searchId && item.status === 'NotReceived');

    if (caseItem) {
      const dialogRef = this.dialog.open(GenerateLetterDialogComponent, {
        width: '600px',
        data: { id: caseItem.id, documentName: caseItem.documentName },
      });

      dialogRef.afterClosed().subscribe((result) => {
        if (result) {
          console.log('Document added:', result);
        }
      });
    } else {
      console.log('No matching item found for the given ID and status.Because of Status is Received');
      const dialogRef = this.dialog.open(GenerateLetterDialogComponent, {
        width: '600px',
      });

      dialogRef.afterClosed().subscribe((result) => {
        if (result) {
          console.log("open dialog",result);
        }
      });
    }
  }
  

}
