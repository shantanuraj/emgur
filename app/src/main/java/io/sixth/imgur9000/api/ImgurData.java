
package io.sixth.imgur9000.api;

import android.os.Parcel;
import android.os.Parcelable;

public class ImgurData implements Parcelable {
    private int account_id;
    private String account_url;
    private int comment_count;
    private String cover;
    private int cover_height;
    private int cover_width;
    private int datetime;
    private String description;
    private int downs;
    private boolean favorite;
    private String id;
    private int images_count;
    private boolean is_album;
    private String layout;
    private String link;
    private boolean nsfw;
    private String privacy;
    private int score;
    private String section;
    private String title;
    private int ups;
    private int views;
    private String vote;

    public int getAccount_id(){
        return this.account_id;
    }
    public void setAccount_id(int account_id){
        this.account_id = account_id;
    }
    public String getAccount_url(){
        return this.account_url;
    }
    public void setAccount_url(String account_url){
        this.account_url = account_url;
    }
    public int getComment_count(){
        return this.comment_count;
    }
    public void setComment_count(int comment_count){
        this.comment_count = comment_count;
    }
    public String getCover(){
        return this.cover;
    }
    public void setCover(String cover){
        this.cover = cover;
    }
    public int getCover_height(){
        return this.cover_height;
    }
    public void setCover_height(int cover_height){
        this.cover_height = cover_height;
    }
    public int getCover_width(){
        return this.cover_width;
    }
    public void setCover_width(int cover_width){
        this.cover_width = cover_width;
    }
    public int getDatetime(){
        return this.datetime;
    }
    public void setDatetime(int datetime){
        this.datetime = datetime;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public int getDowns(){
        return this.downs;
    }
    public void setDowns(int downs){
        this.downs = downs;
    }
    public boolean getFavorite(){
        return this.favorite;
    }
    public void setFavorite(boolean favorite){
        this.favorite = favorite;
    }
    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public int getImages_count(){
        return this.images_count;
    }
    public void setImages_count(int images_count){
        this.images_count = images_count;
    }
    public boolean isAlbum(){
        return this.is_album;
    }
    public void setAlbum(boolean is_album){
        this.is_album = is_album;
    }
    public String getLayout(){
        return this.layout;
    }
    public void setLayout(String layout){
        this.layout = layout;
    }
    public String getLink(){
        return this.link;
    }
    public void setLink(String link){
        this.link = link;
    }
    public boolean getNsfw(){
        return this.nsfw;
    }
    public void setNsfw(boolean nsfw){
        this.nsfw = nsfw;
    }
    public String getPrivacy(){
        return this.privacy;
    }
    public void setPrivacy(String privacy){
        this.privacy = privacy;
    }
    public int getScore(){
        return this.score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public String getSection(){
        return this.section;
    }
    public void setSection(String section){
        this.section = section;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public int getUps(){
        return this.ups;
    }
    public void setUps(int ups){
        this.ups = ups;
    }
    public int getViews(){
        return this.views;
    }
    public void setViews(int views){
        this.views = views;
    }
    public String getVote(){
        return this.vote;
    }
    public void setVote(String vote){
        this.vote = vote;
    }

    //Custom methods
    public String getThumbnail(char size) {
        //Check http://api.imgur.com/models/image
        int lastDot = this.link.lastIndexOf('.');
        String prefix = this.link.substring(0, lastDot);
        String suffix = this.link.substring(lastDot, this.link.length());
        return prefix + size + suffix;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.account_id);
        dest.writeString(this.account_url);
        dest.writeInt(this.comment_count);
        dest.writeString(this.cover);
        dest.writeInt(this.cover_height);
        dest.writeInt(this.cover_width);
        dest.writeInt(this.datetime);
        dest.writeString(this.description);
        dest.writeInt(this.downs);
        dest.writeByte(favorite ? (byte) 1 : (byte) 0);
        dest.writeString(this.id);
        dest.writeInt(this.images_count);
        dest.writeByte(is_album ? (byte) 1 : (byte) 0);
        dest.writeString(this.layout);
        dest.writeString(this.link);
        dest.writeByte(nsfw ? (byte) 1 : (byte) 0);
        dest.writeString(this.privacy);
        dest.writeInt(this.score);
        dest.writeString(this.section);
        dest.writeString(this.title);
        dest.writeInt(this.ups);
        dest.writeInt(this.views);
        dest.writeString(this.vote);
    }

    public ImgurData() {
    }

    private ImgurData(Parcel in) {
        this.account_id = in.readInt();
        this.account_url = in.readString();
        this.comment_count = in.readInt();
        this.cover = in.readString();
        this.cover_height = in.readInt();
        this.cover_width = in.readInt();
        this.datetime = in.readInt();
        this.description = in.readString();
        this.downs = in.readInt();
        this.favorite = in.readByte() != 0;
        this.id = in.readString();
        this.images_count = in.readInt();
        this.is_album = in.readByte() != 0;
        this.layout = in.readString();
        this.link = in.readString();
        this.nsfw = in.readByte() != 0;
        this.privacy = in.readString();
        this.score = in.readInt();
        this.section = in.readString();
        this.title = in.readString();
        this.ups = in.readInt();
        this.views = in.readInt();
        this.vote = in.readString();
    }

    public static final Parcelable.Creator<ImgurData> CREATOR = new Parcelable.Creator<ImgurData>() {
        public ImgurData createFromParcel(Parcel source) {
            return new ImgurData(source);
        }

        public ImgurData[] newArray(int size) {
            return new ImgurData[size];
        }
    };
}
