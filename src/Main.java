
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {
	/**
	 * 
	 * This is main method in this method we are reading text files (user.txt and command.txt)
	 * in this method also routing program flow by the switch case implementation
	 * 
	 * 
	 * */
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		// TODO Auto-generated method stub

		UserCollection users = new UserCollection();
		Scanner scn = new Scanner(new File(args[0]));
		while(scn.hasNextLine()){

			String Line = scn.nextLine();
			String[] linePart = Line.split("\t");

			SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");

			Date newdate = dateformat.parse(linePart[3]);    


			users.addUser(linePart[0], linePart[1], linePart[2], newdate, linePart[4]);

		}

		scn = new Scanner(new File(args[1]));
		while(scn.hasNextLine()){

			String Line = scn.nextLine();
			System.out.println("-----------------------");
			System.out.println("Command: "+Line);
			String[] linePart = Line.split("\t");

			SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
			Date newdate ;
			String[] tmpArray;
			switch (linePart[0]) {
			case "ADDUSER":

				newdate = dateformat.parse(linePart[4]); 
				users.addUser(linePart[1], linePart[2], linePart[3], newdate, linePart[5]);

				break;
			case "REMOVEUSER":

				users.removeUser(Integer.parseInt(linePart[1]));
				break;
			case "SHOWPOSTS":

				users.showPost(linePart[1]);
				break;
			case "SIGNIN":

				users.signInUser(linePart[1], linePart[2]);
				break;
			case "SIGNOUT":

				users.signOutUser();
				break;
			case "UPDATEPROFILE":
				newdate = dateformat.parse(linePart[2]); 
				users.updateProfile(linePart[1], newdate, linePart[3]);
				break;
			case "CHPASS":

				users.changePass(linePart[1], linePart[2]);
				break;
			case "ADDFRIEND":

				users.addFriend(linePart[1]);
				break;
			case "REMOVEFRIEND":

				users.removeFriend(linePart[1]);
				break;
			case "ADDPOST-TEXT":

				tmpArray=linePart[4].split(":");


				if(users.onlineUser.equals(null)){

					System.out.println("Error: Please sign in and try again.");
					break;	
				}



				users.addPostText(linePart[1], Double.parseDouble(linePart[2]), Double.parseDouble(linePart[3]), tmpArray);
				break;
			case "ADDPOST-IMAGE":

				tmpArray=linePart[4].split(":");


				if(users.onlineUser.equals(null)){

					System.out.println("Error: Please sign in and try again.");
					break;	
				}


				String[] resolution = linePart[6].split("x");

				users.addPostImage(linePart[1], Double.parseDouble(linePart[2]), Double.parseDouble(linePart[3]), tmpArray, linePart[5], Integer.parseInt(resolution[0]), Integer.parseInt(resolution[1]));
				break;
			case "ADDPOST-VIDEO":

				tmpArray=linePart[4].split(":");


				if(users.onlineUser.equals(null)){

					System.out.println("Error: Please sign in and try again.");
					break;	
				}


				users.addPostVideo(linePart[1], Double.parseDouble(linePart[2]), Double.parseDouble(linePart[3]), tmpArray, linePart[5],Integer.parseInt(linePart[6]));

				break;
			case "REMOVELASTPOST":
				users.removePost();
				break;
			case "BLOCK":

				users.blockUser(linePart[1]);
				break;
			case "UNBLOCK":

				users.unblockUser(linePart[1]);
				break;
			case "LISTFRIENDS":
				users.listFriend();
				break;
			case "LISTUSERS":
				users.listAllUser();
				break;
			case "SHOWBLOCKEDFRIENDS":
				users.showBlockedFriends();
				break;
			case "SHOWBLOCKEDUSERS":
				users.showBlockedUsers();
				break;	
			default:
				break;
			}
		}

		scn.close();

	}

}
