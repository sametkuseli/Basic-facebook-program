
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
public abstract class Post implements postInterface {

	UUID postID;
	String textInput;
	Date postDate;
	Location location = new Location();
	ArrayList<User> taggedFriends = new ArrayList<User>();

	public void printPost(){

		SimpleDateFormat dFormat = new SimpleDateFormat("dd.MM.yyyy");

		System.out.println(this.textInput);
		System.out.println("Date: "+dFormat.format(this.postDate));
		this.showPostLocation();
		if(this.taggedFriends.size()==0){

			return;
		}else{

			System.out.print("Friends tagged in this post: ");
			this.showTaggedUser();
			System.out.println();

		}	
		System.out.println();

	}
	public void showTaggedUser() {
		// TODO Auto-generated method stub
		for(int i=0;i<this.taggedFriends.size();i++){

			System.out.print(this.taggedFriends.get(i).name);
			if(i==this.taggedFriends.size()-1)continue;
			System.out.print(", ");

		}


	}
	public void showPostLocation() {
		// TODO Auto-generated method stub

		System.out.println("Location: "+this.location.longitude+", "+this.location.latitude);

	}
}
