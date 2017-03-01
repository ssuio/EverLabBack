import { Component } from '@angular/core'
import { NEWSLIST } from './welcomeDomain/newsList'
import { news } from './welcomeDomain/news'

@Component({
	selector:'el-news',
	template:`
		<div class="row" *ngFor='let n of newslist'>
			<div  class="news row col-md-6 col-md-offset-3 rounded" >
				<div class="col-md-3 col-md-offset-2 no-float">
					<img src="assets/images/{{n.picPath}}" class="img-rounded" width="85%">
				</div>
				<div class="col-md-6" no-float>
					<span class="pull-left">&nbsp;&nbsp;&nbsp;&nbsp;{{n.title}}</span>
					<p class="small pull-left">{{n.text}}</p>
				</div>
			</div>
		</div>
	`,
	styles:[
		'.news {margin-top:3%; margin-bot:3%;}',

	]

})

export class ELNewsComponent{

	newslist : news[] = NEWSLIST;
	constructor(){
		console.log(NEWSLIST);
	}
}