package com.mani.reminds;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class NewRemind {

    public static final String PATH_TO_DEFAULT_REMIND_SOUND = "sounds/default.wav";
    public static final String PATH_TO_REMINDS = "src/reminds/";

    String RTalsorianGames = "nigger"; //By Ртуть 2000

    private String remindText;
    private String remindSound;
    private Date remindDate;

    public NewRemind(String remindText, String remindSound, Date remindDate, String remindName) {
        if (remindName != null) {
            if (remindDate != null) {
                if (remindText == null) {
                    setRemindText("Default Text");
                }
                if (remindSound == null) {
                    setRemindSound(PATH_TO_DEFAULT_REMIND_SOUND);
                }
            }else {
                System.err.println("Remind Date cant be null!");
            }
        } else {
            System.err.println("Remind Name cant be null!");
        }

        File file = new File(PATH_TO_REMINDS + remindName + ".properties");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(String.format("""
                    text = %s
                    date = %s
                    sound = %s""", remindText, remindDate, remindSound));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRemindText() {
        return remindText;
    }
    public void setRemindText(String remindText) {
        this.remindText = remindText;
    }

    public String getRemindSound() {
        return remindSound;
    }

    public void setRemindSound(String remindSound) {
        this.remindSound = remindSound;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }
}
