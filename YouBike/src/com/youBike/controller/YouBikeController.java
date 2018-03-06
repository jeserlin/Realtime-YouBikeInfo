package com.youBike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youBike.dto.MessageDTO;
import com.youBike.dto.YouBikeDTO;
import com.youBike.service.YouBikeService;

@Controller
@RequestMapping("/youBike")
public class YouBikeController {

	@Autowired
	private YouBikeService youBikeService;
	
	@RequestMapping("/getYouBikeData")
	public MessageDTO<Object> getYouBikeData() {

		MessageDTO<Object> dto = new MessageDTO<Object>();
		
		//get YouBike data from service.
		try {
			List<YouBikeDTO> list = youBikeService.getYouBikeData();
			dto.setSuccess(true);
			dto.setMessage("get YouBike data successfully.");
			dto.setData(list);
			
		} catch (Exception e) {
			dto.setSuccess(false);
			dto.setMessage("Fail to get YouBike data.");
		}
		return dto;
	}
}
