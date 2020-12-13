package domain;

import constant.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏视图类
 */
public class GameView extends Canvas {

    // 桌面宽高
    private final int TABLE_WIDTH = Constant.TABLE_WIDTH;
    private final int TABLE_HEIGHT = Constant.TABLE_HEIGHT;

    // 游戏规则
    private Rule rule;
    // 球
    private Ball ball;
    // 上球拍
    private Racket racketTop;
    // 下球拍
    private Racket racketBottom;

    // 声明定时器
    private Timer timer;

    public GameView(Ball ball, Racket racketTop, Racket racketBotton) {
        // 设置桌面
        this.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        this.rule = new Rule(ball);
        this.ball = ball;
        this.racketTop = racketTop;
        this.racketBottom = racketBotton;

        // 定时刷新任务
        timer = new Timer(100, event -> {
            // 小球移动
            ball.moveBall(racketBotton.getRacketX());
            this.repaint();
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        if (!rule.isOver(racketBottom.getRacketX())) { // 游戏进行
            paintGame(g);
        } else { // 游戏结束
            paintGameOver(g);
            timer.stop();
        }
    }

    /**
     * 绘制游戏
     */
    private void paintGame(Graphics g) {
        // 绘制小球
        g.setColor(ball.getColor());
        g.fillOval(ball.getBallX(), ball.getBallY(), ball.getBallSize(), ball.getBallSize());

        // 绘制上球拍
        g.setColor(racketTop.getColor());
        g.fillRect(racketTop.getRacketX(), racketTop.getRacketY(), racketTop.getRacketWidth(), racketTop.getRacketHeight());

        // 绘制下球拍
        g.setColor(racketBottom.getColor());
        g.fillRect(racketBottom.getRacketX(), racketBottom.getRacketY(), racketBottom.getRacketWidth(), racketBottom.getRacketHeight());
    }

    /**
     * 绘制游戏结束
     */
    private void paintGameOver(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("隶书", Font.BOLD, 30));
        g.drawString("游戏结束", 130, 300);
    }

}
