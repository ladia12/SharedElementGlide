package sample.com.sharedelementglide;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ladia on 17/06/16.
 */
public class ArticleModel implements Parcelable {
    public String imageUrl;
    public String title;
    public String text;

    protected ArticleModel(Parcel in) {
        imageUrl = in.readString();
        title = in.readString();
        text = in.readString();
    }

    public static final Creator<ArticleModel> CREATOR = new Creator<ArticleModel>() {
        @Override
        public ArticleModel createFromParcel(Parcel in) {
            return new ArticleModel(in);
        }

        @Override
        public ArticleModel[] newArray(int size) {
            return new ArticleModel[size];
        }
    };

    public ArticleModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imageUrl);
        parcel.writeString(title);
        parcel.writeString(text);
    }
}
