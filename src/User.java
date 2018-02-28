

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {

	private int userID;
	String name;
	private String userName;
	private String password;
	Date dateOfBirth;
	String graduatedSchool;
	Date lastLoginDate;
	ArrayList<User> friendList = new ArrayList<User>();
	ArrayList<User> blockList =  new ArrayList<User>();
	ArrayList<Post> postList = new ArrayList<Post>();
	static int userIDcounter;
	public User(String name, String userName, String password, Date dateOfBirth, String graduatedSchool) {

		this.userIDcounter++;
		this.setUserID(userIDcounter);
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.graduatedSchool = graduatedSchool;
		this.lastLoginDate = null;

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * this method confirm sign-in status
	 * @param userName username of user which is going to sign-in 
	 * @param password password of user which is going to sign-in
	 * @return  oparation successfull or not
	 * */
	public boolean signIn(String userName,String password){

		if(checkUserIDPass(userName,password)){

			System.out.println("Sign-In successfull!!");
			return true;
		}else{
			System.out.println("Sign-In unsuccessfull!! Please check your username and password");
			return false;
		}

	}

	public boolean signOut(){

		System.out.println("Exited from account!!");
		return true;
	}

	public boolean updateProfil(String userName, String password, String name, Date birth, String gradSchool){

		if(checkUserIDPass(userName,password)){

			this.name = name;
			this.dateOfBirth = birth;
			this.graduatedSchool = gradSchool;
			System.out.println("Profile updated!!");
			return true;
		}else{

			System.out.println("Profile didn't update!!");
			return false;
		}

	}
	public boolean updateProfil(String userName, String password, String name, String gradSchool){

		if(checkUserIDPass(userName,password)){

			this.name = name;
			this.graduatedSchool = gradSchool;
			System.out.println("Profile updated!!");
			return true;
		}else{

			System.out.println("Profile didn't update!!");
			return false;
		}

	}

	public void updateProfil(String name, Date birth, String gradSchool){



		this.name = name;
		this.dateOfBirth = birth;
		this.graduatedSchool = gradSchool;


	}

	public boolean changePass(String userName, String password){
		if(checkUserIDPass(userName,password)){

			this.password = password;
			return true;
		}else{
			return false;
		}

	}

	public boolean addFriend(String userName , ArrayList<User> list){

		int userIndex = searchUser(userName, list);
		if(userIndex >-1){

			this.friendList.add(list.get(userIndex));
			System.out.println(userName+" named user is added to friend list ");
			return true;
		}else{
			System.out.println(userName+" named user isn't added to friend list ");
			return false;
		}

	}

	public boolean removeFriend(String userName){

		int userIndex = searchUser(userName, this.friendList);
		if(userIndex >-1){

			this.friendList.remove(userIndex);
			return true;
		}else{

			return false;
		}

	}

	public void addPost(Post postIns){

		this.postList.add(postIns);
	}

	public void removePost(){

		this.postList.remove(this.postList.size()-1);

	}

	public void blockUser(User userIns){

		this.blockList.add(userIns);

	}

	public void unBlockUser(int index){

		this.blockList.remove(index);

	}

	public void listFriend(){

		if(this.friendList.size()==0){


			System.out.println("You haven't added any friends yet!");
		}


		for(int i=0; i<this.friendList.size(); i++){

			this.friendList.get(i).printUser();
		}

	}

	public void listAllUser(ArrayList<User> list){

		if(list.size()==0){


			System.out.println("You haven't added any friends yet!");
		}


		for(int i=0; i<list.size(); i++){

			list.get(i).printUser();
		}


	}

	public void showBlockedFriends(){

		if(this.blockList.size()==0){

			System.out.println("You haven't blocked any users yet!");
			return;
		}

		int findCount=0;

		for(int i=0; i< this.blockList.size();i++){

			for(int j=0; j<this.friendList.size();j++){

				if(this.blockList.get(i).userName.equals(this.friendList.get(j).userName)){

					this.blockList.get(i).printUser();
					findCount++;
				}

			}

		}

		if(findCount==0){

			System.out.println("You haven't blocked any friends yet!");
		}

	}

	public void showBlockedUsers(){

		if(this.blockList.size()==0){

			System.out.println("You haven't blocked any users yet!");
			return;
		}
		for(int i=0; i< this.blockList.size();i++){

			this.blockList.get(i).printUser();

		}


	}

	/**
	 * this method printing the user object
	 * 
	 * */

	public void printUser(){

		SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Name: "+this.name);
		System.out.println("Username: "+this.userName);
		System.out.println("Date of Birth: "+dFormat.format(this.dateOfBirth));
		System.out.println("School: "+this.graduatedSchool);
		System.out.println("---------------------------");

	}
	/**
	 * this method search an user in 
	 * @param aList 
	 * @return index of the user in the a specified list
	 * 
	 * */
	public int searchUser(String userName,ArrayList<User> aList){

		for(int i=0; i<aList.size();i++){
			if(aList.get(i).userName.equals(userName)){

				return i;
			}


		}
		return -1;
	}

	/**
	 * this method check-in userName and password combination
	 * @param userName user's username
	 * @param password user's password
	 * @return combination true or false
	 * 
	 * */

	public boolean checkUserIDPass(String userName,String password){

		return userName.equals(this.userName)&&password.equals(this.password);
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


}
