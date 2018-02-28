
import java.util.ArrayList;
import java.util.Date;

/**
 * in this class we are handling user collections
 * */
public class UserCollection {


	ArrayList<User> userList   = new ArrayList<User>();
	User onlineUser ;
	/**
	 * this method adding a new user to the program
	 * @param name user's name
	 * @param userName user's username
	 * @param password user's password
	 * @param dBirth user's date of birth
	 * @param gradSchool user's graduated school name
	 * 
	 * */
	public void addUser(String name, String userName,String password,Date dBirth,String gradSchool){

		if(this.checkUserName(userName)){

			System.out.println(userName+" username already used please change your username");
			return;
		}

		User tempUser = new User(name,userName,password,dBirth,gradSchool);
		userList.add(tempUser);
		System.out.println(name+" has been successfully added.");

	}

	public boolean removeUser(int userID){

		int index = getUserIndex(userID);

		if(index>-1){
			userList.remove(index);
			System.out.println("User has been successfully removed.");
			return true;
		}
		return false;


	}

	public void showPost(String userName){

		if(onlineUser.equals(null)){
			System.out.println("Error: Please sign in and try again.");
			return ;
		}

		int index =
				getUserIndex(userName);

		if(index >-1){

			System.out.println("**************");
			System.out.println(userName+"'s Posts");
			System.out.println("**************");

			for(int i =0; i<userList.get(index).postList.size(); i++){

				userList.get(index).postList.get(i).printPost();
				System.out.println("----------------------");

			}

		}else{

			System.out.println("No such user!");
		}



	}

	public boolean signInUser(String userName, String password){

		int index =
				getUserIndex(userName);
		if(index>-1){
			if(userList.get(index).checkUserIDPass(userName, password)){

				onlineUser = userList.get(index);
				onlineUser.lastLoginDate = new Date();
				System.out.println("You have successfully signed in.");
				return true;
			}else{

				System.out.println("Invalid username or password! Please try again.");
				return false;
			}
		}else{
			System.out.println("No such user!");
			return false;
		}

	}

	public void signOutUser(){

		onlineUser = null;
		System.out.println("You have successfully signed out.");
	}

	public boolean updateProfile(String name , Date doBirth, String gradSchool){

		if(onlineUser.equals(null)){
			System.out.println("Error: Please sign in and try again.");
			return false;
		}else{
			onlineUser.updateProfil(name, doBirth, gradSchool);
			System.out.println("Your user profile has been successfully updated.");
			return true;
		}
	}

	public boolean changePass(String oldPass, String newPass){

		if(onlineUser.equals(null)){
			System.out.println("Error: Please sign in and try again.");
			return false;
		}else{

			if(onlineUser.checkUserIDPass(onlineUser.getUserName(), oldPass)){

				onlineUser.changePass(onlineUser.getUserName(), newPass);
				System.out.println("Password changed successfully.");
				return true;
			}else{
				System.out.println("Password mismatch! Please, try again.");

				return false;
			}



		}

	}

	public boolean addFriend(String userName){

		if(onlineUser.equals(null)){
			System.out.println("Error: Please sign in and try again.");
			return false;
		}

		int index =
				getUserIndex(userName);

		if(index >-1){
			int friendIndex =
					onlineUser.searchUser(userName, onlineUser.friendList);

			if(friendIndex >-1){
				System.out.println("This user is already in your friend list!");
				return false;
			}else{

				onlineUser.friendList.add(userList.get(index));
				System.out.println(userName+" has been successfully added to your friend list.");
				return true;
			}


		}else{
			System.out.println("No such user!");
			return false;
		}

	}

	public boolean removeFriend(String userName){

		if(onlineUser.equals(null)){
			System.out.println("Error: Please sign in and try again.");
			return false;
		}

		int index =
				getUserIndex(userName);

		if(index >-1){
			int friendIndex =
					onlineUser.searchUser(userName, onlineUser.friendList);

			if(friendIndex >-1){
				onlineUser.friendList.remove(userList.get(index));
				System.out.println(userName+" has been successfully removed to your friend list.");
				return true;
			}else{


				System.out.println("No such friend!");
				return false;
			}


		}else{
			System.out.println("No such user!");
			return false;
		}



	}

	public void addPostText(String textContent, double longitude, double latitude,String[] list){

		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}

		ArrayList<User> tagList = new ArrayList<User>();


		for(int i=0; i<list.length; i++){

			int index=
					onlineUser.searchUser(list[i],onlineUser.friendList );

			if(index==-1){

				System.out.println(list[i]+" is not your friend, and will not be tagged!");

			}else{

				tagList.add(onlineUser.friendList.get(index));

			}
		}



		Post postTmp = new Text(textContent,longitude,latitude,tagList);

		onlineUser.addPost(postTmp);

		System.out.println("The post has been successfully added.");


	}

	public void addPostImage(String textContent, double longitude, double latitude, String[] list, String filePath, int width, int height){
		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}

		ArrayList<User> tagList = new ArrayList<User>();
		for(int i=0; i<list.length; i++){

			int index=
					onlineUser.searchUser(list[i],onlineUser.friendList );

			if(index==-1){


				System.out.println(list[i]+" is not your friend, and will not be tagged!");

			}else{

				tagList.add(onlineUser.friendList.get(index));

			}
		}

		Post postTmp = new Image(textContent,longitude,latitude,tagList,filePath,width,height);

		onlineUser.addPost(postTmp);

		System.out.println("The post has been successfully added.");

	}

	public void addPostVideo(String textContent, double longitude, double latitude, String[] list, String filePath, int vidDuration){
		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}
		ArrayList<User> tagList = new ArrayList<User>();
		for(int i=0; i<list.length; i++){

			int index=
					onlineUser.searchUser(list[i],onlineUser.friendList );

			if(index==-1){


				System.out.println(list[i]+" is not your friend, and will not be tagged!");

			}else{

				tagList.add(onlineUser.friendList.get(index));

			}
		}

		if(vidDuration > Video.getVideomaxduration()){

			System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
			return;
		}

		Post postTmp = new Video(textContent,longitude,latitude,tagList,filePath,vidDuration);

		onlineUser.addPost(postTmp);

		System.out.println("The post has been successfully added.");

	}

	public void removePost(){

		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}

		if(onlineUser.postList.size()<1){

			System.out.println("Error: You don't have any posts.");
		}else{


			onlineUser.removePost();
			System.out.println("Your last post has been successfully removed.");
		}



	}

	public void blockUser(String userName){

		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}

		int index =
				onlineUser.searchUser(userName, userList);

		if(index==-1){

			System.out.println("No such user!");

		}else{

			onlineUser.blockList.add(userList.get(index));
			System.out.println(userName+" has been successfully blocked.");
		}


	}

	public void unblockUser(String userName){

		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}

		int index =
				onlineUser.searchUser(userName, onlineUser.blockList);

		if(index==-1){

			System.out.println("No such user in your blocked users list!");

		}else{

			onlineUser.blockList.remove(index);
			System.out.println(userName+" has been successfully unblocked.");
		}
	}

	public void listFriend(){

		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}

		onlineUser.listFriend();

	}

	public void listAllUser(){
		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}
		onlineUser.listAllUser(userList);

	}

	public void showBlockedFriends(){

		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}

		onlineUser.showBlockedFriends();
	}

	public void showBlockedUsers(){

		if(onlineUser.equals(null)){

			System.out.println("Error: Please sign in and try again.");
			return;
		}

		onlineUser.showBlockedUsers();


	}


	/**
	 * this method control of the username exsiting in userList
	 * 
	 * @param userName the username of the will be checking
	 * @return 			username exist or not in the userList
	 * */
	public boolean checkUserName(String userName){

		for(int i= 0; i<this.userList.size(); i++){

			if(userName.equals(userList.get(i).getUserName())){

				return true;
			}

		}
		return false;
	}

	/**
	 * this method return us an extisting user in userList by UserID
	 * @param ID searching ID
	 * @return  searched user index in the userList arraylist
	 * */
	public int getUserIndex(int ID){

		for(int i=0; i<userList.size(); i++){

			if(userList.get(i).getUserID()==ID){
				return (i);
			}


		}
		return -1;
	}
	/**
	 * this method return us an extisting user in userList by UserName
	 * @param name searching username
	 * @return  searched user index in the userList arraylist
	 * */
	public int getUserIndex(String name){

		for(int i=0; i<userList.size(); i++){

			if(userList.get(i).getUserName().equals(name)){
				return (i);
			}


		}
		return -1;
	}

}
