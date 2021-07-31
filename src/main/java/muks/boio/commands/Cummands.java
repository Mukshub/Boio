package muks.boio.commands;

import muks.boio.Boio;
import muks.boio.utils.MessageUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

// gawd my java ocd pls make the c capital in cummands
// thx
public class Cummands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        Thread fukingDoJobThread = new Thread(() -> {
            MessageUtils message = new MessageUtils(event.getMessage());
            String[] args = message.getArgs();
            if (message.startsWith("Boio")) {
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage(":flag_ni::flag_gg::a:").queue();
            }
            if (message.startsWith("mini")) {
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage("https://media.discordapp.net/attachments/650767112532656139/856179914654089226/image0-191.gif").queue();
            }
            if (message.startsWith("credits")) {
                event.getChannel().sendTyping().queue();
                EmbedBuilder halp = new EmbedBuilder();
                halp.setTitle("<:omgboioclientleak:870953841632346164> Bot");
                halp.setDescription("Shit about Boio Bot");
                halp.addField("Creator", "Muks", false);
                halp.addField("Helper", "Senxpai", false);
                halp.setColor(0xeb3434);
                halp.setFooter("Created by Muks", event.getMember().getUser().getAvatarUrl());

                event.getChannel().sendMessage(halp.build()).queue();
            }
            if (message.startsWith("lore")) {
                event.getChannel().sendTyping().queue();
                EmbedBuilder lore = new EmbedBuilder();
                lore.setTitle("<:books:870953519941812225> The Lore");
                lore.setDescription("Boio Lore");
                lore.addField("<:books:870953519941812225>", "https://cdn.discordapp.com/attachments/870742946830491689/870748137055195197/PLOT.txt", false);
                lore.addField("Lore by", "MGO9NG", false);
                lore.setFooter("created by MGO9NG");
                lore.setColor(0x9900ff);
                event.getChannel().sendMessage(lore.build()).queue();
            }
            if (message.startsWith("members")) {
                event.getChannel().sendTyping().queue();
                EmbedBuilder members = new EmbedBuilder();
                members.setTitle("<:mens:870956548904587344> All The Members of Boio");
                members.addField("Boio Owners", "Ran " + "Icaz " + "Muks " + "Ryan " + "Lmaowat " + "MGO9NG " + "TheGamerPopular ", false);
                members.addField("Members", "MGO9NG " + "Suryablaze " + "Dabeast " + "Nibble " + "Epic Gamer " + "Blindness ", false);
                members.setColor(0x2200ff);
                event.getChannel().sendMessage(members.build()).queue();
            }
            if (message.containsAt("sus", 0)) {
                File file = new File("D:\\Downloads 4\\SUS.mp3");
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage("OMG U HAVE THE SUSSY!?!?").addFile(file).queue();
            }// r u omging? // QUICK NOW IS MY CHANCE
            // no im sadg
            if (message.startsWith("halp")) {
                event.getChannel().sendTyping().queue();
                EmbedBuilder halp = new EmbedBuilder();
                halp.setTitle("Commands for Boio Bot");
                halp.addField("Prefix", "^", false);
                halp.addField("Boio Lore", "lore", false);
                halp.addField("racizme", "boio", false);
                halp.addField("minimogus", "mini", false);
                halp.addField("Credits", "credits", false);
                halp.setTitle("Extras:");
                halp.setDescription("these don't require Prefixes");
                halp.addField("sus", "@Boio", false);
                halp.setColor(0xb3bdb5);
                event.getChannel().sendMessage(halp.build()).queue();
            }
            java.util.List<Member> mentionedMembers = message.getMessage().getMentionedMembers();
            for (Member mentionedMember : mentionedMembers) {
                if (mentionedMember.getId().equals("870710683166195824")) {
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessage("My prefix is:" + Boio.prefix).queue();
                }
            }
            if (message.startsWith("kick")) {
                event.getMember().kick().queue();
            }

            if (message.startsWith("t1t")) {
                event.getChannel().sendMessage("yes I'm here");
            }
        });
        fukingDoJobThread.run();
    }
}


