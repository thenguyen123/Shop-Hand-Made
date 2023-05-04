import {Component, OnInit} from '@angular/core';
import Swal from 'sweetalert2';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {ShareService} from '../../security-authentication/service/share.service';
import {Router} from '@angular/router';
import {Types} from '../../model/types';
import {TypesService} from '../../service/types.service';
import {AppUserService} from '../../service/app-user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  username: string;
  currentUser: string;
  nameUser: string;
  role: string;
  isLoggedIn = false;
  searchName = '';
  types: Types[];
  idTypes = 0;
  img: string;

  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private router: Router, private typesService: TypesService, private  appUser: AppUserService) {
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.currentUser = this.tokenStorageService.getUser().username;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.findUser();
    this.isLoggedIn = this.username != null;
    this.getUsernameAccount();
  }


  ngOnInit(): void {
    this.findAllTypes();
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();

    });

    this.loadHeader();

  }

  async logOut() {
    this.tokenStorageService.signOut();
    this.shareService.sendClickEvent();
    await Swal.fire({
      text: 'Đăng xuất thành công',
      icon: 'success',
      showConfirmButton: false,
      timer: 1500
    });
    await this.router.navigateByUrl('/');
    location.reload();
  }

  getUsernameAccount() {
    if (this.tokenStorageService.getToken()) {
      this.nameUser = this.tokenStorageService.getUser().name;
    }
  }

  search() {
    this.router.navigate(['product/list/', this.searchName, this.idTypes]);
  }

  findAllTypes() {
    this.typesService.findAll().subscribe(param => {
      this.types = param;
    });
  }

  findUser() {
    this.appUser.findUser(this.tokenStorageService.getUser().username).subscribe(param => {
      this.img = param.img;
    });
  }
}
