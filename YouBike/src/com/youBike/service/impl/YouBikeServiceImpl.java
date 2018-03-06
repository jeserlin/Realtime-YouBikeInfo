package com.youBike.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.youBike.dto.YouBikeDTO;
import com.youBike.service.YouBikeService;

@Repository
public class YouBikeServiceImpl implements YouBikeService {

	@Override
	public List<YouBikeDTO> getYouBikeData() throws IOException {
		URL url = new URL("https://tcgbusfs.blob.core.windows.net/blobyoubike/YouBikeTP.gz");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		JSONObject jsonObj;
		try (InputStream inputStream = con.getInputStream()) {
			BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)));
			String content = in.readLine();
			jsonObj = new JSONObject(content);
		}
		jsonObj = jsonObj.getJSONObject("retVal");
		List<YouBikeDTO> list = new ArrayList<YouBikeDTO>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(Object key : jsonObj.keySet()) {
			String keyStr = (String)key;
			JSONObject keyValue = jsonObj.getJSONObject(keyStr);
			YouBikeDTO dto = new YouBikeDTO();
			dto.setSno(keyValue.getString("sno"));
			dto.setSna(keyValue.getString("sna"));
			dto.setTot(Integer.parseInt(keyValue.getString("tot")));
			dto.setSbi(Integer.parseInt(keyValue.getString("sbi")));
			dto.setSarea(keyValue.getString("sarea"));
			dto.setMday(keyValue.getString("mday"));
			dto.setLat(Float.parseFloat(keyValue.getString("lat")));
			dto.setLng(Float.parseFloat(keyValue.getString("lng")));
			dto.setAr(keyValue.getString("ar"));
			dto.setSareaen(keyValue.getString("sareaen"));
			dto.setSnaen(keyValue.getString("snaen"));
			dto.setAren(keyValue.getString("aren"));
			dto.setBemp(Integer.parseInt(keyValue.getString("bemp")));
			dto.setAct((keyValue.getString("act").equals("1")) ? true : false);
			list.add(dto);
		}
		return list;
	}
}
