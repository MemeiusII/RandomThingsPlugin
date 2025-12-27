package me.EthanBilbrey.RandomThings;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileHandler 
{
	private static File file;
	private static FileConfiguration customFile;
	
	public static void setup() 
	{
		try 
		{
			file = new File(Bukkit.getServer().getPluginManager().getPlugin("RandomThings").getDataFolder(), "PluginSettings.yml");
			
			if(!file.exists()) 
			{
				customFile = YamlConfiguration.loadConfiguration(file);
				file.getParentFile().mkdirs();
				
				file.createNewFile();
				customFile.set("TimeInterval", 3.0);
				customFile.save(file);
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void save() 
	{
		try 
		{
			customFile.save(file);
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	//call before using file
	public static void reload() 
	{
		customFile = YamlConfiguration.loadConfiguration(file);
	}
	
	public static void setValue(String path, double value) 
	{
		customFile.set(path, value);
	}
	
	public static double getValue(String path) 
	{
		double value = Double.parseDouble(String.valueOf(customFile.get(path)));
		return value;
	}
}
