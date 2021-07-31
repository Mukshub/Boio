package muks.boio;

import muks.boio.commands.Cummands;
import muks.boio.commands.Clear;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
/*
 R: IS THIS GAYISTA?
 M: NO ITS PANSEXUAL
 R: AH OKIE!
 SENXPAI: (don't delete this it'll stay here for end of time or something) */
/* gg
 gg */


/**
 * @author muks
 */
public class Boio {


    public static JDA jda;
    public static String prefix = "^";
    
    public static void main(String[] args) {
        try {
            jda = JDABuilder.createDefault("ODcwNzEwNjgzMTY2MTk1ODI0.YQQugw.jxZI8NKySQWdGgBP5SNprT7Jt1g").build();
            jda.getPresence().setStatus(OnlineStatus.IDLE);
            jda.getPresence().setActivity(Activity.playing("getting coded on"));
            jda.addEventListener(new Cummands(), new Clear());
        } catch (LoginException loginException) {
            loginException.printStackTrace();
        }
    }
}
