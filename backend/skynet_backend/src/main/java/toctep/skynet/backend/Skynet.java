package toctep.skynet.backend;

import toctep.skynet.backend.bll.GeoTaggedTweetRetriever;

public final class Skynet {

	private Skynet() { }
	
	public static void main(String[] args) {
		Log.initialize();
		
		new Thread(new GeoTaggedTweetRetriever()).start();
	}

}
