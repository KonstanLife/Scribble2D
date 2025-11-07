package utilz;

public class Constants {
	
	
	public static class Direcions{
		
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}
	
	public static class PlayerConstants{
		
	

	public static final int IDLE = 0;
	public static final int RUNNING = 1;
	public static final int JUMP = 2;
	public static final int FALLING = 3;
	public static final int GOUND = 4;
	public static final int HIT = 5;
	public static final int ATTACK_1 = 6;
	public static final int ATTACK_2 = 7;
	public static final int ATTACK_3 = 8;
	
	
	public static int GetSpriteAmount(int player_action) {
		
		switch (player_action) {
		case IDLE:
			return 4;
		case RUNNING:
		case JUMP:
		case ATTACK_1:
		case ATTACK_2:
		case ATTACK_3:
			return 7;
		case FALLING:
			return 3;
		case GOUND:
			return 1;
		case HIT:
			return 1;

		default:
			return 1;
		}
	}
	
	}
	
}
