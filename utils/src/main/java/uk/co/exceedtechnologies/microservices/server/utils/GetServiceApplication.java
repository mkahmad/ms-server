package uk.co.exceedtechnologies.microservices.server.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetServiceApplication {
	static int I = 0;
	static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetServiceApplication gsa = new GetServiceApplication();
		gsa.execute();
	}

	public void execute() {

		for (int k = 0; k < 10; k++) {
			long a1 = System.currentTimeMillis();
			
			for (int i = 0; i < 300; i++) {
				new Thread(prepareThread(k)).start();
			}
			System.out.println(k + " " + I + " " + (System.currentTimeMillis() - a1));
			System.out.println("Max time " + max);
		}
	}

	public Runnable prepareThread(final int pack) {
		
		return new Runnable() {
			public void run() {
				GetClient g = new GetClient("http://localhost/");
				long time = g.get();
				if (time > 1000) {
					if (max < time) {
						max = (int) time;
					}
					System.out.println(pack + " " + I + " " + g.q + " Time taken : " + time);
				}
//				I--;
			}
		};
	}

	static class GetClient {

		HttpURLConnection con;
		public int q;

		public GetClient(String uri) {
			
			URL url;
			try {
				url = new URL(uri);
				con = (HttpURLConnection) url.openConnection();
				q = ++I;
				con.setDoOutput(true);
				con.setRequestMethod("GET");
				con.setConnectTimeout(2000);
				con.setReadTimeout(500);

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public long get() {
			long l1 = System.currentTimeMillis();
			try {
				con.getResponseCode();
				con.disconnect();
				I--;
			} catch (Exception e) {
				System.out.println(I + " " + q + "failed to process in " + (l1 - System.currentTimeMillis()));
			}
			return System.currentTimeMillis() - l1;
		}
	}
}
