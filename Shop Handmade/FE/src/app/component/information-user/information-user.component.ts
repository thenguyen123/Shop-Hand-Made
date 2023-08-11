import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {ShareService} from '../../security-authentication/service/share.service';
import {Router} from '@angular/router';
import {TypesService} from '../../service/types.service';
import {AppUserService} from '../../service/app-user.service';
import {CardService} from '../../service/card.service';
import {AppUser} from '../../model/app-user';

@Component({
  selector: 'app-information-user',
  templateUrl: './information-user.component.html',
  styleUrls: ['./information-user.component.css']
})
export class InformationUserComponent implements OnInit {
  user: AppUser;

  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private router: Router, private typesService: TypesService,
              private  appUser: AppUserService, private cartDetail: CardService) {
  }

  ngOnInit(): void {
    this.findUser();
  }

  findUser() {
    this.appUser.findUser(this.tokenStorageService.getUser().username).subscribe(param => {
      this.user = param;
    });
  }
}
