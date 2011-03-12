package me.saac.i.ai;

import java.util.ArrayList;

import me.saac.i.ai.GameState.Action;

// interface for different opponent models
// (as we'll be experimenting with several and comparing)
public interface OpponentModel {
	public double winPossibility(ArrayList<Action> history, int playerHandStrength);
	
	public double[] actionProbabilities(ArrayList<Action> history);
	
	public void input(ArrayList<Action> history, int handStrength);
}
