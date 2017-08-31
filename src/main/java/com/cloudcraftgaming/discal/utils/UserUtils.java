package com.cloudcraftgaming.discal.utils;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nova Fox on 3/29/2017.
 * Website: www.cloudcraftgaming.com
 * For Project: DisCal
 */
public class UserUtils {
	public static IUser getUserFromMention(String mention, MessageReceivedEvent event) {
		for (IUser u : event.getGuild().getUsers()) {
			if (mention.equalsIgnoreCase("<@" + u.getStringID() + ">") || mention.equalsIgnoreCase("<@!" + u.getStringID() + ">")) {
				return u;
			}
		}

		return null;
	}



	public static long getUser(String toLookFor, IMessage m) {
		return getUser(toLookFor,m.getGuild());
	}

	/**
	 * Gets a user on the guild
	 *
	 * @param toLookFor The name or ID, if the user was mentioned this can be anything
	 * @param m         The message, incase of mention
	 * @return The ID of the user found.
	 */
	/**
	 * Grabs a user from a string
	 *
	 * @param toLookFor The String to look with
	 * @param guild     The guild
	 * @return The user if found, null otherwise
	 */
	public static long getUser(String toLookFor, IGuild guild) {
		toLookFor = toLookFor.trim();

		List<String> lol = new ArrayList<>();
		String k = lol.stream().filter(s -> s.length() == 4).findFirst().orElse(null);

		if (toLookFor.matches("<@!?[0-9]+>")) {
			IUser exists = guild.getUserByID(Long.parseLong(toLookFor.replaceAll("[<@!>]", "")));
			if (exists != null) {
				return exists.getLongID();
			}
		}

		final String lower = toLookFor.toLowerCase();
		List<IUser> users = new ArrayList<>();
		List<IUser> us = guild.getUsers();
		users.addAll(us.stream().filter(u -> u.getName().equalsIgnoreCase(lower)).collect(Collectors.toList()));
		users.addAll(us.stream().filter(u -> u.getName().toLowerCase().contains(lower)).collect(Collectors.toList()));
		users.addAll(us.stream().filter(u -> (u.getName() + "#" + u.getDiscriminator()).equalsIgnoreCase(lower)).collect(Collectors.toList()));
		users.addAll(us.stream().filter(u -> u.getDiscriminator().equalsIgnoreCase(lower)).collect(Collectors.toList()));
		users.addAll(us.stream().filter(u -> u.getDisplayName(guild).equalsIgnoreCase(lower)).collect(Collectors.toList()));
		users.addAll(us.stream().filter(u -> u.getDisplayName(guild).toLowerCase().contains(lower)).collect(Collectors.toList()));
		if (!users.isEmpty()) {
			return users.get(0).getLongID();
		}

		return 0;
	}

	public static IUser getIUser(String toLookFor, IMessage m, IGuild guild) {
		toLookFor = toLookFor.trim();
		final String lower = toLookFor.toLowerCase();

		IUser res = null;

		if (m != null && !m.getMentions().isEmpty())
			res = m.getMentions().get(0);

		if (toLookFor.matches("<@!?[0-9]+>")) {
			IUser u = guild.getUserByID(Long.parseUnsignedLong(toLookFor.replaceAll("[^0-9]", "")));
			if (u != null) {
				return u;
			}
		}

		List<IUser> users = guild.getUsers().stream()
				.filter(u -> u.getName().toLowerCase().contains(lower)
						|| u.getName().equalsIgnoreCase(lower) || u.getStringID().equals(lower)
						|| u.getDisplayName(guild).toLowerCase().contains(lower)
						|| u.getDisplayName(guild).equalsIgnoreCase(lower))
				.collect(Collectors.toList());
		if (!users.isEmpty())
			res = users.get(0);

		return res;
	}

}