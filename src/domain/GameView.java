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

    // 分数
    private int score;

    public GameView(Ball ball, Racket racketTop, Racket racketBotton) {
        // 设置桌面
        this.setPreferredSize(new Dimension(TABLE_WIDTH + Constant.TABLE_WIDTH_EXTEND, TABLE_HEIGHT));
        this.rule = new Rule();
        this.ball = ball;
        this.racketTop = racketTop;
        this.racketBottom = racketBotton;

        // 定时刷新任务
        timer = new Timer(100, event -> {
            // 小球移动
            ball.moveBall(racketBotton.getRacketX());
            // 统计分数
            if (rule.scoreAdd(ball)) {
                score++;
            }
            // 绘制界面
            this.repaint();
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        if (!rule.isOver(ball, racketBottom.getRacketX())) { // 游戏进行
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

        // 绘制直线
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(452, 0, 2, 600);

        // 绘制分数板
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(475, 130, 100,100);

        // 绘制分数
        g.setColor(Color.black);
        g.setFont(new Font("隶书", Font.BOLD, 30));
        g.drawString(Integer.toString(score), 515, 190);
    }

    /**
     * 绘制游戏结束
     */
    private void paintGameOver(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("隶书", Font.BOLD, 30));
        g.drawString("游戏结束", 130, 300);

        // 绘制直线
        g.setColor(racketBottom.getColor());
        g.fillRect(452, 0, 2, 600);

        // 绘制分数板
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(475, 130, 100,100);

        // 绘制分数
        g.setColor(Color.black);
        g.setFont(new Font("隶书", Font.BOLD, 30));
        g.drawString(Integer.toString(score), 515, 190);
    }

    /**
     * 游戏的开始和暂停
     */
    public void runStatus() {
        if (timer.isRunning()) {
            timer.stop();
        } else {
            timer.start();
        }
    }

}
