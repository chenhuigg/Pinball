package domain;

import constant.Constant;

import java.awt.*;

/**
 * 球类
 */
public class Ball {
    // 大小
    private int ballSize = Constant.BALL_SIZE;

    // 颜色
    private Color color = Constant.BALL_COLOR;

    // 坐标位置
    private int ballX;
    private int ballY;

    // 速度大小
    private int speedX = Constant.speedX;
    private int speedY = Constant.speedY;

    public Ball(int ballX, int ballY) {
        this.ballX = ballX;
        this.ballY = ballY;
    }

    /**
     * 小球移动
     * @param racketX :球拍位置，目前游戏中上球拍和下球拍racketX位置相同
     */
    public void moveBall(int racketX) {
        // 小球速度方向改变
        if (ballX <= 0 || ballX >= Constant.TABLE_WIDTH - ballSize) { // X轴方向速度
            speedX = -speedX;
        }
        if ((ballY <= Constant.racketHeight || ballY >= Constant.TABLE_HEIGHT - Constant.racketHeight - ballSize)
                && ballX > racketX - ballSize && ballX < racketX + Constant.racketWidth) { // Y轴方向速度
            speedY = -speedY;
        }

        ballX += speedX;
        ballY += speedY;
    }

    public int getBallSize() {
        return ballSize;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getBallX() {
        return ballX;
    }

    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public int getBallY() {
        return ballY;
    }

    public void setBallY(int ballY) {
        this.ballY = ballY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}
