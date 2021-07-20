import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './room/create/create.component';
import { DetailComponent } from './room/detail/detail.component';
import { ListComponent } from './room/list/list.component';
import { UpdateComponent } from './room/update/update.component';

const routes: Routes = [
  { path: '', redirectTo: 'rooms', pathMatch: 'full' },
  { path: 'rooms', component: ListComponent },
  { path: 'add', component: CreateComponent },
  { path: 'update/:id', component: UpdateComponent },
  { path: 'details/:id', component: DetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
