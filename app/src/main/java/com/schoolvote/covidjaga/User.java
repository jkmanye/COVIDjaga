package com.schoolvote.covidjaga;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class User {

    private String email;
    private String password;
    private int age;
    private boolean isMan;
    private String name;

    public User(FirebaseUser user, String pw) {
        setEmail(user.getEmail());
        setPassword(pw);
        FirebaseFirestore.getInstance().collection("users").document(user.getEmail()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot d = task.getResult();
                setAge((int) d.get("age"));
                setMan((boolean) d.get("isMan"));
                setName((String) d.get("name"));
            }
        });
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public boolean isMan() { return isMan; }

    public void setMan(boolean man) { isMan = man; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
