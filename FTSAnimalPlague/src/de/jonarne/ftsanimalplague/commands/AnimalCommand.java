package de.jonarne.ftsanimalplague.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.jonarne.ftsanimalplague.main.Main;

public class AnimalCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			FileConfiguration config = Main.getPlugin().getConfig();
			Main.getPlugin().saveConfig();
			if(args.length == 0) {
				player.sendMessage("§cZu wenig Argumente. Bitte verwende §6/animal help§c.");
			} else if(args[0].equalsIgnoreCase("help")) {
				player.sendMessage("§7-----§2 FTSAnimalPlague §7-----");
				player.sendMessage("§6/animal help §f- §7Zeigt diese Hilfe an.");
				player.sendMessage("§6/animal settings §f- §7Zeige und verändere alle Einstellungen.");
				player.sendMessage("§6/animal info §f- §7Zeigt Informationen über das Plugin.");
				player.sendMessage("§6/animal reset §f- §7Setze alle EInstellungen und Werte auf den Standartwert.");
				player.sendMessage("§7------- §2by JonArne §7-------");
				player.sendMessage(" ");
			} else if(args[0].equalsIgnoreCase("settings")) {
				if(player.hasPermission("animalplague.set")) {
					if(args.length == 1) {
						player.sendMessage("§7-----§2 FTSAnimalPlague §7-----");
						player.sendMessage("§6/animal settings [Einstellung] [Wert]");
						player.sendMessage("§7-----------------------------");
						player.sendMessage("§6maxmobs§a: Wie viele Kreaturen in einem Radius von 10 Blöcken stehen dürfen (z.B. 5).");
						player.sendMessage("§6cooldown§a: Die Zeit bis die Seuche ausgelöst wird (in Sekunden).");
						player.sendMessage("§7---");
						player.sendMessage("§6active§a: Aktiviere die Seuche (true) oder deaktiviere sie (false).");
						player.sendMessage(" ");
					} else if(args[1].equalsIgnoreCase("maxmobs")) {
						if(args.length==3) {
							int valueMaxmobs = Integer.parseInt(args[2]);
							if(valueMaxmobs<=100) {
								config.set("FTSAnimalPlague.settings.maxmobs", valueMaxmobs);
								player.sendMessage("§aDie Einstellung §6maxmobs §awurde auf §6" + valueMaxmobs + "§a gesetzt.");
							} else {
								player.sendMessage("§cDer Wert darf nicht mehr als 100 betragen.");
							}
						} else {
							player.sendMessage("§cZu viele Argumente.");
						}
						
					} else if(args[1].equalsIgnoreCase("cooldown")) {
						if(args.length==3) {
							int valueCooldown = Integer.parseInt(args[2]);
							int configCooldown = valueCooldown*20;
							config.set("FTSAnimalPlague.settings.valueCooldown", configCooldown);
							player.sendMessage("§aDie Einstellung §6cooldown §awurde auf §6" + valueCooldown + "§a gesetzt.");
							} else {
								player.sendMessage("§cZu viele Argumente.");
							}
					} else if(args[1].equalsIgnoreCase("active")) {
						if(args.length==3) {
							boolean booActive = Boolean.parseBoolean(args[2]);
							config.set("FTSAnimalPlague.settings.active", booActive);
							player.sendMessage("§aDie Einstellung §6active §awurde auf §6" + booActive + "§a gesetzt.");
						} else {
							player.sendMessage("§cZu viele Argumente.");
						}
					}
				} else {
					player.sendMessage("§cDu benötigst Adminrechte um diesen Befehl ausführen zu können.");
				}
				Main.getPlugin().saveConfig();
			} else if(args[0].equalsIgnoreCase("info")) {
				player.sendMessage("§7-----§2 FTSAnimalPlague §7-----");
				player.sendMessage("§aFügt die Tierseuche im Spiel ein um riesige Tierfarmen zu unterbinden.");
				player.sendMessage("§aVersion: §61.0");
				player.sendMessage("§7------- §2by JonArne §7-------");
				player.sendMessage(" ");
			} else if(args[0].equalsIgnoreCase("reset")) {
				config.set("FTSAnimalPlague.settings.maxmobs", 100);
				config.set("FTSAnimalPlague.settings.valueCooldown", 9999);
				config.set("FTSAnimalPlague.settings.active", false);
				player.sendMessage("§aAlle Einstellungen wurden zurückgesetzt.");
				Main.getPlugin().saveConfig();
			}
		}
		
		return false;
	}

}
