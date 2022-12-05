package it.macgood.mathanapp.ui.handbook.demidovich;

public class Chapter {

    private int id;
    private String mChapter;
    private String mName;
    private String mPages;
    private String mExercises;

    public Chapter(int id, String mChapter, String mName, String mPages, String mExercises) {
        this.id = id;
        this.mChapter = mChapter;
        this.mName = mName;
        this.mPages = mPages;
        this.mExercises = mExercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChapter() {
        return mChapter;
    }

    public void setChapter(String mChapter) {
        this.mChapter = mChapter;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getPages() {
        return mPages;
    }

    public void setPages(String mPages) {
        this.mPages = mPages;
    }

    public String getExercises() {
        return mExercises;
    }

    public void setExercises(String mExercises) {
        this.mExercises = mExercises;
    }
}
