package toctep.skynet.backend;

import toctep.skynet.backend.bll.Server;

public class Main {

	public static void main(String[] args) {
		new Thread(new Server()).start();
	}

}
