package muks.boio.commands;

import muks.boio.Boio;
import muks.boio.utils.MessageUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Clear extends ListenerAdapter {

    public boolean repeating = false;
    public static void deleteAfter(Message message, int delay) {
        message.delete().queueAfter(delay, TimeUnit.SECONDS);
    }
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        Thread EA = new Thread(() -> {

            MessageUtils message = new MessageUtils(event.getMessage());
        String[] args = message.getArgs();
        if (message.startsWith("yeetusdeletus") || message.startsWith("clear") || message.startsWith("purge")
                || message.startsWith("mymom")) {
            if (args.length < 2) {
                // Usage
                EmbedBuilder usage = new EmbedBuilder();
                usage.setColor(0xff3923);
                usage.setTitle("clear how much?");
                usage.setDescription("Usage: `" + Boio.prefix + "clear [# of messages]`");
                event.getChannel().sendMessage(usage.build()).queue();
            } else {
                try {
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1]) + 1).complete();
                    if ((Integer.parseInt(args[1]) + 1) > 100) {
                        // it's greater than 100 meaning time to do mee6 stuff
                        // meaning we have to clear like twice or thrice cause greater than 100

                        // PRO TIP: You might wanna use multithreading so the bot doesn't like halt
                        // but idk if multithreading will work on discord
                        // halting means the bot will completely stop until the current action is finished
                    }
                    event.getChannel().deleteMessages(messages).queue();

                    // Success
                    EmbedBuilder success = new EmbedBuilder();
                    success.setColor(0x22ff2a);
                    success.setTitle("✅ SUSscessfully yeeted " + args[1] + " messages.");
                    event.getChannel().sendMessage(success.build()).queue(m -> m.delete().queueAfter(2000000000, TimeUnit.NANOSECONDS));
                } catch (IllegalArgumentException e) {
                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                        // Too many messages
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("too much for me");
                        error.setDescription("Between 2-100 messages can be deleted at one time.");
                        event.getChannel().sendMessage(error.build()).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
                        e.printStackTrace();
                    } else {
                        // Messages too old
                        EmbedBuilder error = new EmbedBuilder();
                        error.setColor(0xff3923);
                        error.setTitle("too old for me ( i like them young :D)");
                        error.setDescription("Messages older than 2 weeks cannot be deleted.");
                        event.getChannel().sendMessage(error.build()).queue();                            // i don't think ints/longs support decimals
                        event.getChannel().sendMessage(error.build()).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
                    }
                }
            }
        }        });
        EA.run();


    }}