package edu.pam.tugas_rancang.entity;

public class Tour {
    private int id;
    private String name;
    private String desc = "";
    private int user_id = 0;

    public Tour(int id, String name, String desc, int user_id){
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
