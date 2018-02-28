
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
public class Text extends Post {


	public Text(String value,double longitude, double latitude,ArrayList<User> list){

		super();
		this.postID = UUID.randomUUID();
		this.textInput = value;
		this.location.longitude = longitude;
		this.location.latitude = latitude;
		this.postDate = new Date();
		this.taggedFriends = list;


	}

	@Override
	public void showTaggedUser(Post thePost) {
		// TODO Auto-generated method stub
		for(int i=0; i<thePost.taggedFriends.size(); i++){

			System.out.println(thePost.taggedFriends.get(i));
		}
	}



	@Override
	public void showPostLocation(Post thePost) {
		// TODO Auto-generated method stub
		System.out.println(thePost.location.latitude);
		System.out.println(thePost.location.longitude);
	}

}
