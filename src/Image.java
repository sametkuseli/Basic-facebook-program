
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Image extends Text {

	private String filename;
	private int resWidth;
	private int resHeight;
	public Image(String value, double longitude, double latitude, ArrayList<User> list, String filename, int resWidth,
			int resHeight) {
		super(value, longitude, latitude, list);
		this.filename = filename;
		this.resWidth = resWidth;
		this.resHeight = resHeight;
	}
	/**
	 * printing post
	 * */
	public void printPost(){


		SimpleDateFormat dFormat = new SimpleDateFormat("dd.MM.yyyy");

		System.out.println(this.textInput);
		System.out.println("Date: "+dFormat.format(this.postDate));
		this.showPostLocation();
		System.out.println("Image: "+this.filename);
		System.out.println("Image resolution: "+this.resWidth+"x"+this.resHeight);

		if(this.taggedFriends.size()==0){

			return;
		}else{

			System.out.print("Friends tagged in this post: ");
			this.showTaggedUser();
			System.out.println();

		}	
		System.out.println();
	}
}
