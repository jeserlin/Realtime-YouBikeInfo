package com.youBike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.youBike.dto.MessageDTO;

@Controller
public class YouBikeController {
 
	@RequestMapping("/getYouBikeData")
	public MessageDTO<Object> getYouBikeData() {
		MessageDTO<Object> dto = new MessageDTO<Object>();
		return dto;
	}
}
