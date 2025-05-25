import { Injectable } from '@angular/core';
import axios, { AxiosResponse } from 'axios';

const API_URL = 'http://localhost:8081/registration-service/api/register';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor() {}

  registerUser(data: any): Promise<AxiosResponse<any>> {
    return axios.post(API_URL, data)
      .then(response => response) // Handle the response
      .catch(error => {
        console.error('There was an error!', error);
        throw error; // Handle the error
      });
  }
}
