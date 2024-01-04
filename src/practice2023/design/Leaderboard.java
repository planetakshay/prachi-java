package practice2023.design;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leaderboard {
    Map<Integer, Integer> scores;
    Map<Integer, Integer> scoreToPlayers;

    public Leaderboard() {
        scores = new HashMap<>();
        scoreToPlayers = new TreeMap<>(Collections.reverseOrder());
    }
    public void addScore(int playerId, int score) {
        if (!scores.containsKey(playerId)) {
            scores.put(playerId, score);
            scoreToPlayers.put(score, scoreToPlayers.getOrDefault(score, 0) + 1);
        } else {
            int old = scores.get(playerId);
            int players = scoreToPlayers.get(old);
            if (players == 1) {
                scoreToPlayers.remove(old);
            } else {
                scoreToPlayers.put(old, players - 1);
            }
            int newS = old + score;
            scores.put(playerId, newS);
            scoreToPlayers.put(newS, scoreToPlayers.getOrDefault(newS, 0) + 1);
        }
    }

    public int top(int K) {
        int sum = 0;
        int playerCount = 0;
        for (Map.Entry<Integer, Integer> entry : scoreToPlayers.entrySet()) {
            int players = entry.getValue();
            int score = entry.getKey();

            for (int i = 0; i < players; i++) {
                sum += score;
                playerCount++;
                if (playerCount == K) {
                    break;
                }
            }
            if (playerCount == K) {
                break;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        int old = scores.get(playerId);
        scoreToPlayers.put(old, scoreToPlayers.get(old) - 1);
        if (scoreToPlayers.get(old) == 0) {
            scoreToPlayers.remove(old);
        }
        scores.remove(playerId);
    }
}