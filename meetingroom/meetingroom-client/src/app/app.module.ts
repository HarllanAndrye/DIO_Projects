import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateComponent } from './room/create/create.component';
import { DetailComponent } from './room/detail/detail.component';
import { ListComponent } from './room/list/list.component';
import { UpdateComponent } from './room/update/update.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateComponent,
    DetailComponent,
    ListComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
