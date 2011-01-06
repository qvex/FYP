package me.saac.i;

import me.saac.i.GameState.Action;

import java.util.ArrayList;
import java.util.HashMap;

public class OpponentModel {
	private HashMap<Integer, int[]> historyToHandStrength = new HashMap<Integer, int[]>();
	
	public int[] winPossibility(ArratList<Action> history, int playerHandStrength) {
		int numRaises = 0;
		for(Action a : history) {
			if(a == Action.RAISE) {
				numRaises++;
			}
		}
		
		int[] histogram = historyToHandStrength.get(numRaises);
		int aphs = adjustedHandStrength(playerHandStrength);
	}
	
	public void input(ArrayList<Action> history, int handStrength) {
		int numRaises = 0;
		for(Action a : history) {
			if(a == Action.RAISE) {
				numRaises++;
			}
		}
		
		int ahs = adjustedHandStrength(handStrength);
		if(historyToHandStrength.get(numRaises) == null) {
			int[] histogram = new int[] {0,0,0,0,0,0,0,0,0,0};
			historyToHandStrength.put(numRaises, histogram);
		}
		int[] histogram = historyToHandStrength.get(numRaises);
		histogram[ahs] = histogram[ahs] + 1;
		
		System.out.print("OpponentModel["+numRaises+"] <- ");
		for(int i = 0; i < histogram.length; i++) {
			System.out.print(histogram[i] + " - ");
		}
	}
	
	private int adjustedHandStrength(int rawHandStrength) {
		int ahs = rawHandStrength / 1000;
		return Math.min(ahs, 9);
	}
}
