package com.ipartek.formacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class Utilidades {

	private final static Logger LOG = Logger.getLogger(Utilidades.class);

	/**
	 * Descarga una imagen desde internet
	 * @param search url donde busca la imagen
	 * @param path directorio donde se guarda, es necesario especificar tambien el nombre y estension de la imaegn
	 * @throws IOException
	 */
	public static void downloadImage(String search, String path) throws IOException {

		// This will get input data from the server
		InputStream inputStream = null;

		// This will read the data from the server;
		OutputStream outputStream = null;

		// This will open a socket from client to server
		URL url = new URL(search);

		// This user agent is for if the server wants real humans to visit
		String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";

		// This socket type will allow to set user_agent
		URLConnection con = url.openConnection();

		// Setting the user agent
		con.setRequestProperty("User-Agent", USER_AGENT);

		// Requesting input data from server
		inputStream = con.getInputStream();

		// Open local file writer
		outputStream = new FileOutputStream(path);

		// Limiting byte written to file per loop
		byte[] buffer = new byte[2048];

		// Increments file size
		int length;

		// Looping until server finishes
		while ((length = inputStream.read(buffer)) != -1) {
			// Writing data
			outputStream.write(buffer, 0, length);
		}

		// close resources
		outputStream.close();
		inputStream.close();
		
		LOG.debug("Imagen bajado con exito: " + path);

	}

}
