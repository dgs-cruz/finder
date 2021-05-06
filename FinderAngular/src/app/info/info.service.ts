import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Info } from "./info";

@Injectable()
export class InfoService {

    constructor(private http: HttpClient) { }

    protected UrlServiceV1: string = "http://localhost:8080/";

    getInfo(): Observable<Info[]> {
        return this.http.get<Info[]>(this.UrlServiceV1 + "info");
    }

    getFilteredInfo(placa : string, startDate : Date, endDate : Date): Observable<Info[]> {
        let params = {};

        if (placa) params = {...params, placa: placa};
        if (startDate) params = {...params, startDate: startDate.toLocaleString('pt-BR')};
        if (endDate) params = {...params, endDate: endDate.toLocaleString('pt-BR')};

        return this.http.get<Info[]>(this.UrlServiceV1 + "info", {params: params});
    }
}
