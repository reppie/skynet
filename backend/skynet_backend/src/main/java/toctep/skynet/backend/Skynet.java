package toctep.skynet.backend;

import toctep.skynet.backend.bll.GeoTaggedTweetRetriever;
import toctep.skynet.backend.log.Log;

public final class Skynet {

	private Skynet() {}
	
	public static void main(String[] args) {
		Log.initialize();
		
		new Thread(new GeoTaggedTweetRetriever()).start();
	}

}
