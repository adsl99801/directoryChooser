package com.lfo.directorychooser;

import android.os.Parcel;
import android.os.Parcelable;


public  class DirectoryChooserConfig implements Parcelable {


    /**
     * Name of the directory to create. User can change this name when he creates the
     * folder. To avoid this use {@link #allowNewDirectoryNameModification} argument.
     */
    public String newDirectoryName="";

    /**
     * Optional argument to define the path of the directory
     * that will be shown first.
     * If it is not sent or if path denotes a non readable/writable directory
     * or it is not a directory, it defaults to
     * {@link android.os.Environment#getExternalStorageDirectory()}
     */
    public String initialDirectory="";

    /**
     * Argument to define whether or not the directory chooser
     * allows read-only paths to be chosen. If it false only
     * directories with read-write access can be chosen.
     */
    public boolean allowReadOnlyDirectory=true;


    /**
     * Argument to define whether or not the directory chooser
     * allows modification of provided new directory name.
     */
    public boolean allowNewDirectoryNameModification=true;

    public String cancel_labelStr="取消";
    public String confirm_labelStr="確定";

    public DirectoryChooserConfig() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.newDirectoryName);
        dest.writeString(this.initialDirectory);
        dest.writeByte(this.allowReadOnlyDirectory ? (byte) 1 : (byte) 0);
        dest.writeByte(this.allowNewDirectoryNameModification ? (byte) 1 : (byte) 0);
        dest.writeString(this.cancel_labelStr);
        dest.writeString(this.confirm_labelStr);
    }

    protected DirectoryChooserConfig(Parcel in) {
        this.newDirectoryName = in.readString();
        this.initialDirectory = in.readString();
        this.allowReadOnlyDirectory = in.readByte() != 0;
        this.allowNewDirectoryNameModification = in.readByte() != 0;
        this.cancel_labelStr = in.readString();
        this.confirm_labelStr = in.readString();
    }

    public static final Creator<DirectoryChooserConfig> CREATOR = new Creator<DirectoryChooserConfig>() {
        @Override
        public DirectoryChooserConfig createFromParcel(Parcel source) {
            return new DirectoryChooserConfig(source);
        }

        @Override
        public DirectoryChooserConfig[] newArray(int size) {
            return new DirectoryChooserConfig[size];
        }
    };
}
