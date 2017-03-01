import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';

import { ELAppComponent } from './everlab-app.component';

import { WelcomeComponent } from './welcome.component';
import { ELHeaderComponent } from './el-header.component';
import { ELFooterComponent } from './el-footer.component';
import { ELNewsComponent } from './news.component';

import { ELBookComponent } from './el-book.component';


@NgModule({
  declarations: [
    ELAppComponent,
    WelcomeComponent,
    ELHeaderComponent,
    ELFooterComponent,
    ELNewsComponent,
    ELBookComponent,
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    NgbModule.forRoot(),
    RouterModule.forRoot([
      {
        path: 'welcome',
        component: WelcomeComponent
      },
      {
        path: 'elbook',
        component: ELBookComponent
      },
      {
        path: '',
        redirectTo: '/welcome',
        pathMatch: 'full'
      },
      ])
  ],
  providers: [],
  bootstrap: [
   ELAppComponent
  ]
})
export class AppModule { }
