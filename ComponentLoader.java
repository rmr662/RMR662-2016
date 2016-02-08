package org.usfirst.frc.team662.robot;

import java.io.File;
import java.util.*;
public class ComponentLoader {

	File sourceDir;

	public ComponentLoader() {
		try {
			sourceDir = new File(ComponentLoader.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		}
		catch (Exception e) {
			System.out.println("Error loading source directory.");
		}
	}

	public Component[] loadComponents() {
		ClassLoader cl = ComponentLoader.class.getClassLoader();
		ArrayList<String> classes = new ArrayList<String>();
		for (String s : sourceDir.list()) {
			if (s.endsWith(".class")) {
				classes.add(s);
			}
		}

		Component [] components = new Component[classes.size()];
		int compI = 0;
		for (int i = 0; i < components.length; i++) {
			String name = classes.get(i);
			Class c = null;
			try {
				c = cl.loadClass(name.substring(0, name.length() - 6));
			}
			catch (Exception e) {
				System.out.println("Error loading class: " + name);
			}
			if (c.getSuperclass() == Component.class) {
				try {
					components[compI] = (Component)c.newInstance();
					compI++;
				}
				catch (Exception e) {
					System.out.println("Error creating component: " + name);
				}
			}
		}

		return components;
			
	}

}
