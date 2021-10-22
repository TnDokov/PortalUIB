package com.example.loginform;

public class HelperClass {

    int image;
    String deadline,matkul;

    public HelperClass(int image, String deadline, String matkul) {
        this.image = image;
        this.deadline = deadline;
        this.matkul = matkul;
    }

    public int getImage() {
        return image;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getMatkul() {
        return matkul;
    }
}
