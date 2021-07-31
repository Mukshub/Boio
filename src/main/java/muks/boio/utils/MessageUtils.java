package muks.boio.utils;

import muks.boio.Boio;
import net.dv8tion.jda.api.entities.Message;

public class MessageUtils {
    private net.dv8tion.jda.api.entities.Message message;
    private String[] args;

    public MessageUtils(net.dv8tion.jda.api.entities.Message message) {
        this.message = message;
        this.args = message.getContentRaw().split("\\s+");
    }

    public boolean startsWith(String string) {
        return args[0].equalsIgnoreCase(Boio.prefix + string);
    }

    public boolean containsAt(String string, int arg) {
        return args[arg].equalsIgnoreCase(string);
    }

    public String[] getArgs() {
        return args;
    }

    public Message getMessage() {
        return message;
    }
}
