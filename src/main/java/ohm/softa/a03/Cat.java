package ohm.softa.a03;

import ohm.softa.a03.ohm.softa.a03.states.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import static ohm.softa.a03.Cat.State.*;

public class Cat {
	private static final Logger logger = LogManager.getLogger();

	private State currentState;

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;

		this.currentState = new SleepingState(sleep);
	}

	public void tick(){
		this.currentState = currentState.tick(this);
	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");

		// change state
		logger.info("you are feeding the cat...");
		currentState = ((HungryState) currentState).feed(this);
	}

	public boolean isAsleep() {	return currentState instanceof SleepingState; }

	public boolean isPlayful() { return currentState instanceof PlayfulState;	}

	public boolean isHungry() {	return currentState instanceof HungryState;	}

	public boolean isDigesting() { return currentState instanceof DigestingState;}

	public boolean isDead() {	return currentState instanceof DeathState; }

	@Override
	public String toString() {
		return name;
	}

	public int getSleep() {
		return this.sleep;
	}

	public int getDigest() {
		return this.digest;
	}

	public int getAwake() {
		return this.awake;
	}

	public String getName() {
		return name;
	}
}
