package com.youBike.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.youBike.dto.YouBikeDTO;

public interface YouBikeService {

	/**
	 * get YouBike realtime data from Data.Taipei
	 * 
	 * @return List<YouBikeDTO>
	 * @throws MalformedURLException 
	 * @throws IOException 
	 */
	List<YouBikeDTO> getYouBikeData() throws MalformedURLException, IOException;
}
