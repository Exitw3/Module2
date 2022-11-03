package S8_CleanAndRefactoring.bai_tap.refactoring_kata_tenis_game;

public class TennisGame {
    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";

    public static void main(String[] args) {
        String result = getScore(55, 5);
        System.out.println(result);
    }

    public static String draw(int score) {
        String result ;
        switch (score) {
            case 0:
                result = LOVE_ALL;
                break;
            case 1:
                result = FIFTEEN_ALL;
                break;
            case 2:
                result = THIRTY_ALL;
                break;
            case 3:
                result = FORTY_ALL;
                break;
            default:
                result = DEUCE;
                break;
        }
        return result;
    }

    public static String advantageThan(int range) {
        if (range == 1)
            return ADVANTAGE_PLAYER_1;
        if (range == -1)
            return ADVANTAGE_PLAYER_2;
        if (range >= 2)
            return WIN_FOR_PLAYER_1;
        return WIN_FOR_PLAYER_2;
    }

    public static String getScore(int scorePlayer1, int scorePlayer2) {
        StringBuilder score = new StringBuilder();
        int tempScore;
        if (scorePlayer1 == scorePlayer2) {
            score = new StringBuilder(draw(scorePlayer1));
            return score.toString();
        }
        if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            int minusResult = scorePlayer1 - scorePlayer2;
            return advantageThan(minusResult);
        }
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = scorePlayer1;
            else {
                score.append("-");
                tempScore = scorePlayer2;
            }
            switch (tempScore) {
                case 0:
                    score.append(LOVE);
                    break;
                case 1:
                    score.append(FIFTEEN);
                    break;
                case 2:
                    score.append(THIRTY);
                    break;
                case 3:
                    score.append(FORTY);
                    break;
            }
        }
        return score.toString();
    }
}