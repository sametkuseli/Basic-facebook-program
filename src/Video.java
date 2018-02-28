
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Video extends Text {

	private String filename;
	private int videoDuration;
	private static final int  videoMaxDuration = 10;
	public Video(String value, double longitude, double latitude, ArrayList<User> list, String filename,
			int videoDuration) {

		super(value, longitude, latitude, list);
		this.filename = filename;
		this.videoDuration = videoDuration;
	}

	public void printPost(){

		SimpleDateFormat dFormat = new SimpleDateFormat("dd.MM.yyyy");

		System.out.println(this.textInput);
		System.out.println("Date: "+dFormat.format(this.postDate));
		this.showPostLocation();
		System.out.println("Video: "+this.filename);
		System.out.println("Video duration: "+this.videoDuration+" minutes");
		if(this.taggedFriends.size()==0){

			return;
		}else{

			System.out.print("Friends tagged in this post: ");
			this.showTaggedUser();
			System.out.println();

		}	
		System.out.println();
	}

	public static int getVideomaxduration() {
		return videoMaxDuration;
	}

}
