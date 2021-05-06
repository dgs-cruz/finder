package com.acutisti.finder.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acutisti.finder.domain.Info;
import com.acutisti.finder.dto.FiltroDTO;
import com.acutisti.finder.services.InfoService;

@RestController
@RequestMapping(value="/info")
@CrossOrigin
public class InfoResource {
	
	@Autowired
	private InfoService infoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> posicoes(
			@RequestParam(required=false, value="startDate") String startDate,
			@RequestParam(required=false, value="endDate") String endDate,
			@RequestParam(required=false, value="placa") String placa) throws ParseException {
		FiltroDTO filtro = new FiltroDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if (startDate != null)
			filtro.setStartDate(sdf.parse(startDate));
		
		if (endDate != null)
			filtro.setEndDate(sdf.parse(endDate));
		
		filtro.setPlaca(placa);
		
		List<Info> infos = infoService.buscar(filtro);
		
		return ResponseEntity.ok().body(infos);
	}
}
