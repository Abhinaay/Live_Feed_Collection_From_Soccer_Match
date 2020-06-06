import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatchPayload} from './match-payload';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatchServiceService {

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Array<MatchPayload>>{
    return this.httpClient.get<Array<MatchPayload>>('https://soccer-live-feeds-spring.herokuapp.com/api/all');
  }
}
