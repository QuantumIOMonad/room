package me.gfred.room.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private Long mId;

    @ColumnInfo(name = "full_name")
    private String mFullName;

    @ColumnInfo(name = "email")
    private String mEmail;

    @ColumnInfo(name = "password")
    private String mPassword;

    public User(@NonNull Long mId, @NonNull String mFullName, @NonNull String mEmail, @NonNull String mPassword) {
        this.mId = mId;
        this.mEmail = mEmail;
        this.mPassword = mPassword;
        this.mFullName = mFullName;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
