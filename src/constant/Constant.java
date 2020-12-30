package constant;

import java.awt.*;
import java.util.Random;

public class Constant {
    // 桌面宽高
    public static final int TABLE_WIDTH = 450;
    public static final int TABLE_HEIGHT = 600;
    // 桌面宽度 扩展部分
    public static final int TABLE_WIDTH_EXTEND = 150;

    // 球的大小
    public static final int BALL_SIZE = 16;
    // 球的颜色
    public static final Color BALL_COLOR = Color.RED;
    // 球的速度
    public static final int speedX = new Random().nextInt(5) + 5;
    public static final int speedY = new Random().nextInt(5) + 10;

    // 球拍长宽
    public static final int racketWidth = 60;
    public static final int racketHeight = 20;
    // 球拍颜色
    public static final Color RACKET_COLOR = Color.LIGHT_GRAY;
    // 球拍每次移动距离
    public static final int moveLength = 10;

}

