package modele;

public class ConnexionApp {

	private static String[][] identifiants = { { "nic", "nicnic" }, { "dav", "davdav" }, { "prof", "profprof" } };

	public static boolean verificationConn( String user, String pw ) {

		for (String[] qqun : identifiants ) {
			if (user.equals( qqun[0] ) && pw.equals( qqun[1] ) ) {
				return true;
			}
		}
		return false;
	}
}