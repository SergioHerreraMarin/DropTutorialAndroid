package com.drop.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.drop.game.Game;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(800, 480); //Establecer ventana de 800 x 480
		config.setTitle("DropTutorialGame"); //Titulo de ventana
		config.useVsync(true); //Activar Vsync
		new Lwjgl3Application(new Game(), config);
	}
}
