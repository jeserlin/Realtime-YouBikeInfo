package com.youBike.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.zip.GZIPInputStream;

import org.springframework.stereotype.Repository;

import com.youBike.dto.YouBikeDTO;
import com.youBike.service.YouBikeService;

@Repository
public class YouBikeServiceImpl implements YouBikeService {

	@Override
	public List<YouBikeDTO> getYouBikeData() throws IOException {
		URL url = new URL("https://tcgbusfs.blob.core.windows.net/blobyoubike/YouBikeTP.gz");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		Reader reader = null;
		if ("gzip".equals(con.getContentEncoding())) {
			reader = new InputStreamReader(new GZIPInputStream(con.getInputStream()));
		} else {
			reader = new InputStreamReader(con.getInputStream());
		}
		String data = "";
		while (true) {
			int ch = reader.read();
			if (ch == -1) {
				break;
			}
			System.out.print((char) ch);
			data += String.valueOf(ch);
		}
		return null;
	}

}
