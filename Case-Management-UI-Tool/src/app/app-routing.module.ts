import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { GenerateLetterDialogComponent } from './generate-letter-dialog/generate-letter-dialog.component';
import { FollowUpModalComponent } from './follow-up-modal/follow-up-modal.component';

const routes: Routes = [
  {path:'',component:HomeComponent,
   children:[
    {path:'generateletter',component:GenerateLetterDialogComponent}]
  },
  {path:'followup',component:FollowUpModalComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
