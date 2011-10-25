package test;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Test {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
		    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/skynet?" + "user=skynet&password=asdasd");
		    System.out.println("Connected!");
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
    /*public static void main(String[] args) throws TwitterException {
        if (args.length < 1) {
            System.out.println("Usage: java twitter4j.examples.PrintFilterStream [follow(comma separated numerical user ids)] [track(comma separated filter terms)]");
            System.exit(-1);
        }

        StatusListener listener = new StatusListener() {
            public void onStatus(Status status) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }

            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };

        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(listener);
        ArrayList<Long> follow = new ArrayList<Long>();
        ArrayList<String> track = new ArrayList<String>();
        for (String arg : args) {
            if (isNumericalArgument(arg)) {
                for (String id : arg.split(",")) {
                    follow.add(Long.parseLong(id));
                }
            } else {
                track.addAll(Arrays.asList(arg.split(",")));
            }
        }
        long[] followArray = new long[follow.size()];
        for (int i = 0; i < follow.size(); i++) {
            followArray[i] = follow.get(i);
        }
        String[] trackArray = track.toArray(new String[track.size()]);

        //double[][] coords = { {3.39, 51.17}, {7.29, 53.51} }; // Nederland
        //double[][] coords = { {6.19, 53.09}, {7.22, 53.51} }; // Provincie Groningen
        double[][] coords = { {6.45, 53.16}, {6.65, 53.26} }; // Groningen
        //double[][] coords = { {6.52, 53.23}, {6.55, 53.25} }; // Zernike Complex
        
        // filter() method internally creates a thread which manipulates TwitterStream
        // and calls these adequate listener methods continuously.
        twitterStream.filter(new FilterQuery(0, followArray, null, coords));
        //twitterStream.filter(new GeoQuery(new GeoLocation(0, 0)));
    }

    private static boolean isNumericalArgument(String argument) {
        String args[] = argument.split(",");
        boolean isNumericalArgument = true;
        for (String arg : args) {
            try {
                Integer.parseInt(arg);
            } catch (NumberFormatException nfe) {
                isNumericalArgument = false;
                break;
            }
        }
        return isNumericalArgument;
    }*/

}
