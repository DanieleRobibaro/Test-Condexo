import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  constructor() {}

  favoriteSeason: string | undefined;
  seasons: string[] = ['Male', 'Female', 'Other'];

  email = new FormControl('', [Validators.required, Validators.email]);
  password = new FormControl('', [
    Validators.required,
    Validators.minLength(4),
  ]);
  name = new FormControl('', [Validators.required]);
  Lastname = new FormControl('', [Validators.required]);
  zipcode = new FormControl('', [Validators.maxLength(5)]);
  code = new FormControl('', [Validators.maxLength(3)]);
  number = new FormControl('', [
    Validators.maxLength(10),
    Validators.minLength(8),
  ]);

  ngOnInit(): void {}

  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a valid value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  register() {
    Swal.fire('Good job!', 'You have registered successfully', 'success');
  }
}
