package edu.umb.cs680.hw06;

public class DVDPlayer {
	
	private static DVDPlayer instance = null;
	private  static State state;
	 
	private DVDPlayer(State s) { 
		 state = s;
	}
	
	public static  DVDPlayer getInstance() {
		 if (instance == null) {
			 State s = DrawerClosedNotPlaying.getInstance();
	         instance = new DVDPlayer(s);
	     } 
		 return instance;
	}
	
	public void changeState(State s) {
		 state = s;
	}
	public Object getState() {
		 return state;
	}
	
    public void openCloseButtonPushed() {
	     state.openCloseButtonPushed();
	}

	public void playButtonPushed() {
		 state.playButtonPushed();
	}

	public void stopButtonPushed() {
	     state.stopButtonPushed();
    }
	public void open() {
		 System.out.println("open dvd player");
    }
	public void close() {
	     System.out.println("Close DVD player");
	}
	public void play() {
	     System.out.println("Play DVD player");
	}

	public void stop() {
	     System.out.println("Stop DVD player");
	}

}
