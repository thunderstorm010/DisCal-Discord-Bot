package com.cloudcraftgaming.discal.module.misc;

import com.cloudcraftgaming.discal.Main;
import sx.blah.discord.handle.obj.Status;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Created by Nova Fox on 3/5/2017.
 * Website: www.cloudcraftgaming.com
 * For Project: DisCal
 */
public class StatusChanger extends TimerTask {
    private final ArrayList<String> statuses = new ArrayList<>();
    private Integer index;

    /**
     * Creates the StatusChanger and its Statuses list.
     */
    StatusChanger() {
        statuses.add("Discord Calendar");
        statuses.add("Use !help for help");
        statuses.add("Use !DisCal for info");
        statuses.add("Made by NovaFox161");
        statuses.add("Official calendar bot!");
        statuses.add("Used on %count% guilds!");
        statuses.add("Version " + Main.version);
        statuses.add("!discal settings for info");
        statuses.add("Support DisCal on patron!");
        index = 0;
    }

    @Override
    public void run() {
        String statusOr = statuses.get(index);
        String status = statusOr;
        if (statusOr.contains("%count%")) {
            status = statusOr.replaceAll("%count%", String.valueOf(Main.client.getGuilds().size()));
        }
        Main.client.changeStatus(Status.game(status));

        //Set new index.
        if (index + 1 >= statuses.size()) {
            index = 0;
        } else {
            index++;
        }
    }
}