package domain;

import constant.Constant;

import java.awt.*;

/**
 * 球拍类
 */
public class Racket {
    // 长宽
    private int racketWidth = Constant.racketWidth;
    private int racketHeight = Constant.racketHeight;

    // 颜色
    private Color color = Constant.RACKET_COLOR;

    // 位置
    private int racketX;
    private int racketY;

    public Racket(int racketX, int racketY) {
        this.racketX = racketX;
        this.racketY = racketY;
    }

    /**
     * 左移动球拍
     * @param moveLength 移动长度
     */
    public void moveLeft(int moveLength) {
        if (racketX > 0) {
            racketX -= moveLength;
        }
    }

    /**
     * 右移动球拍
     * @param moveLength 移动长度
     */
    public void moveRight(int moveLength) {
        if (racketX < Constant.TABLE_WIDTH - racketWidth) {
            racketX += moveLength;
        }
    }

    public int getRacketWidth() {
        return racketWidth;
    }

    public void setRacketWidth(int racketWidth) {
        this.racketWidth = racketWidth;
    }

    public int getRacketHeight() {
        return racketHeight;
    }

    public void setRacketHeight(int racketHeight) {
        this.racketHeight = racketHeight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRacketX() {
        return racketX;
    }

    public void setRacketX(int racketX) {
        this.racketX = racketX;
    }

    public int getRacketY() {
        return racketY;
    }

    public void setRacketY(int racketY) {
        this.racketY = racketY;
    }
}
