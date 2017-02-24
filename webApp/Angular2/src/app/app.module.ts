import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AlertModule } from 'ng2-bootstrap/ng2-bootstrap';

import { WelcomeComponent } from './welcome.component';

@NgModule({
  declarations: [
    WelcomeComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule.forRoot(),
    AlertModule.forRoot()
  ],
  providers: [],
  bootstrap: [WelcomeComponent]
})
export class AppModule { }
