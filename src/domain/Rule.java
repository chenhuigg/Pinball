package domain;

import constant.Constant;

/**
 * 游戏规则类
 */
public class Rule {

    private int preSpeed = Constant.speedY;

    public Rule() {
    }

    /**
     * 游戏是否结束
     * @param ball 球类
     * @param racketX 球拍位置，目前游戏中上球拍和下球拍racketX位置相同
     */
    public boolean isOver(Ball ball, int racketX) {
        // 游戏结束
        if ((ball.getBallY() <= Constant.racketHeight || ball.getBallY() >= Constant.TABLE_HEIGHT - Constant.racketHeight - ball.getBallSize())
                && (ball.getBallX() <= racketX - ball.getBallSize() || ball.getBallX() >= racketX + Constant.racketWidth)) {
            return true;
        }
        return false;
    }

    /**
     * 是否加分
     * @param ball 球类
     */
    public boolean scoreAdd(Ball ball) {
        if (preSpeed != ball.getSpeedY()) {
            this.preSpeed = ball.getSpeedY();
            return true;
        }
        return false;
    }

}
