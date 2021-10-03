package id.ac.umn.uts_mobileappprog_34182;

import java.io.Serializable;

public class AudioObject implements Serializable {

    private String title;
    private String category;
    private String audioURI;

    public AudioObject(String title, String category, String audioURI){
        this.title = title;
        this.category = category;
        this.audioURI = audioURI;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAudioURI() {
        return audioURI;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAudioURI(String audioURI) {
        this.audioURI = audioURI;
    }


}
