import { Component, OnInit } from '@angular/core';
import { DateAdapter, MAT_DATE_FORMATS } from '@angular/material/core';
import { Info } from '../shared/info';
import { InfoService } from '../info.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Filtro } from '../shared/filtro';

import { AppDateAdapter, APP_DATE_FORMATS } from '../shared/format-datepicker';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  providers: [
    { provide: DateAdapter, useClass: AppDateAdapter },
    { provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS }
  ]
})
export class TimelineComponent implements OnInit {
  formFiltro: FormGroup;

  constructor(
    private infoService: InfoService,
  ) { }

  public infos: Info[];

  ngOnInit(): void {
    this.createForm(new Filtro());
    this.infoService.getInfo()
      .subscribe(
        infos => {
          this.infos = infos
          console.log(infos)
        },
        error => console.log(error)
      );
  }

  createForm(filtro: Filtro) {
    this.formFiltro = new FormGroup({
      placa: new FormControl(filtro.placa),
      startDate: new FormControl(filtro.startDate),
      endDate: new FormControl(filtro.endDate),
    })
  }

  onSubmit() {
    this.infoService.getFilteredInfo(this.formFiltro.get(['placa']).value, this.formFiltro.get(['startDate']).value, this.formFiltro.get(['endDate']).value).subscribe(
      infos => {
        this.infos = infos;
        console.log(infos);
      },
      error => console.log(error)
    );
    console.log(this.formFiltro.value);
  }

}
