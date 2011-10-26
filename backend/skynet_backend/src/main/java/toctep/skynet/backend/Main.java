package toctep.skynet.backend;

import toctep.skynet.backend.bll.TweetRetriever;

public class Main {

	public static void main(String[] args) {
		new Thread(new TweetRetriever()).start();
	}

}
